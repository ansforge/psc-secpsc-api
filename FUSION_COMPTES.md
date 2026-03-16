# Documentation : Fusion des comptes PSC

## Vue d'ensemble

La fusion de comptes permet d'associer un identifiant PSI (UUID) à un identifiant professionnel existant (RPPS, ADELI, etc.). Cette opération lie deux identifiants pour qu'ils pointent vers le même compte utilisateur.

## Architecture

```
psc-secpsc-api (Proxy)
    ↓
    PUT /user?nationalId={existingId}
    ↓
psc-ps-api (Backend)
    ↓
    PUT /v2/ps?extraId={existingId}
    ↓
MongoDB + psc-toggle-ids (Fusion)
```

## Endpoints

### psc-secpsc-api
```
PUT /user?nationalId={existingId}
Content-Type: application/json

Body: User object avec le nouveau nationalId
```

### psc-ps-api
```
PUT /v2/ps?extraId={existingId}
Content-Type: application/json

Body: Ps object avec le nouveau nationalId
```

## Paramètres

| Paramètre | Description | Exemple |
|-----------|-------------|---------|
| `existingId` / `extraId` | Identifiant du compte existant à fusionner | `810001234567` (RPPS) |
| `ps.nationalId` (body) | Nouvel identifiant (généralement UUID PSI) | `d2c6b2a4-83a1-4d4b-94e8-73982a9600a1` |
| `alternativeIdentifiers` | Liste des identifiants alternatifs incluant l'existingId | `[{ "identifier": "810001234567", "origine": "RPPS" }]` |

## Processus de fusion

### 1. Recherche du compte existant

```java
String searchId = existingId != null && !existingId.isEmpty() ? existingId : ps.getNationalId();
Ps storedPs = psRepository.findByIdsContaining(searchId);
```

Le système recherche le compte existant en utilisant le paramètre `existingId` (ou `extraId`).

### 2. Mise à jour du compte

Le compte existant est mis à jour avec :
- **Préservation de l'`_id` MongoDB** : Le document MongoDB conserve son identifiant technique
- **Ajout du nouveau nationalId** : L'UUID PSI est ajouté à la liste `ids`
- **Mise à jour des alternativeIdentifiers** : Tous les identifiants sont convertis en triplets (identifier, origin, quality)

```java
// Exemple de liste ids après fusion
ids: ["810001234567", "d2c6b2a4-83a1-4d4b-94e8-73982a9600a1"]

// Exemple de alternativeIdentifiers après fusion
alternativeIdentifiers: [
  { "identifier": "810001234567", "origin": "RPPS", "quality": 1 },
  { "identifier": "d2c6b2a4-83a1-4d4b-94e8-73982a9600a1", "origin": "PSI", "quality": 2 }
]
```

### 3. Déclenchement de la fusion (togglePsref)

**Fusion basée sur le changement de nationalId :**
```java
if (existingId != null && !ps.getNationalId().equals(existingId)) {
    PsRef psRef = new PsRef(existingId, ps.getNationalId(), ps.getActivated(), ps.getDeactivated());
    toggleApiDelegateImpl.togglePsref(psRef);
}
```

**Fusion basée sur les alternativeIdentifiers :**
```java
if (ApiUtils.isValidUUID(ps.getNationalId()) && ps.getAlternativeIds() != null) {
    for (AlternativeIdentifier altId : ps.getAlternativeIds()) {
        String altIdentifier = altId.getIdentifier();
        if (!altIdentifier.equals(ps.getNationalId())) {
            Ps existingPsToMerge = psRepository.findByIdsContaining(altIdentifier);
            if (existingPsToMerge != null && !existingPsToMerge.getNationalId().equals(ps.getNationalId())) {
                PsRef psRef = new PsRef(altIdentifier, ps.getNationalId(), ps.getActivated(), ps.getDeactivated());
                toggleApiDelegateImpl.togglePsref(psRef);
            }
        }
    }
}
```

### 4. Enregistrement de la référence (PsRef)

Un objet `PsRef` est créé pour tracer la fusion :

```java
public class PsRef {
    private String nationalIdRef;  // Ancien ID (RPPS)
    private String nationalId;     // Nouveau ID (UUID PSI)
    private Long activated;        // Timestamp d'activation
    private Long deactivated;      // Timestamp de désactivation (null si actif)
}
```

## Exemple concret

### Scénario : Fusion d'un compte RPPS avec un compte PSI

**Situation initiale :**
- Compte RPPS : `810001234567` (Jean Dupont, médecin)
- Nouveau compte PSI à créer : UUID généré

**Requête de fusion :**
```bash
curl -X PUT "http://localhost:8085/psc-secpsc-api/api/user?nationalId=810001234567" \
  -H "Content-Type: application/json" \
  -d '{
    "nationalId": "d2c6b2a4-83a1-4d4b-94e8-73982a9600a1",
    "civilStatus": {
      "lastName": "Dupont",
      "firstNames": "Jean",
      "birthdate": "1980-01-01",
      "genderCode": "M"
    },
    "alternativeIdentifiers": [
      {
        "identifier": "810001234567",
        "origine": "RPPS",
        "quality": 1
      }
    ],
    "contactInfo": {
      "email": "jean.dupont@example.com",
      "phone": "+33612345678"
    }
  }'
```

**Résultat dans MongoDB :**
```json
{
  "_id": "507f1f77bcf86cd799439011",
  "nationalId": "d2c6b2a4-83a1-4d4b-94e8-73982a9600a1",
  "ids": [
    "810001234567",
    "d2c6b2a4-83a1-4d4b-94e8-73982a9600a1"
  ],
  "alternativeIds": [
    {
      "identifier": "810001234567",
      "origin": "RPPS",
      "quality": 1
    },
    {
      "identifier": "d2c6b2a4-83a1-4d4b-94e8-73982a9600a1",
      "origin": "PSI",
      "quality": 2
    }
  ],
  "lastName": "Dupont",
  "firstNames": [
    { "firstName": "Jean", "order": 0 }
  ],
  "activated": 1701619200,
  "deactivated": null
}
```

**PsRef créé :**
```json
{
  "nationalIdRef": "810001234567",
  "nationalId": "d2c6b2a4-83a1-4d4b-94e8-73982a9600a1",
  "activated": 1701619200,
  "deactivated": null
}
```

## Comportement après fusion

### Recherche par identifiant
Les deux identifiants permettent de retrouver le même compte :

```bash
# Recherche par RPPS
GET /user?nationalId=810001234567
# Retourne le compte fusionné

# Recherche par UUID PSI
GET /user?nationalId=d2c6b2a4-83a1-4d4b-94e8-73982a9600a1
# Retourne le même compte fusionné
```

### Préservation des professions
Pour les comptes PSI (UUID), les professions du compte RPPS sont **préservées** :

```java
if (ApiUtils.isValidUUID(ps.getNationalId())) {
    if (storedPs.getProfessions() != null && !storedPs.getProfessions().isEmpty()) {
        ps.setProfessions(storedPs.getProfessions());
    }
}
```

## Cas d'erreur

### 410 Gone - Compte désactivé
```
PUT /user?nationalId=810001234567

Response: 410 Gone
```
Le compte existant a été désactivé (soft delete), impossible de le fusionner.

### 404 Not Found - Compte inexistant
```
PUT /user?nationalId=999999999999

Response: 404 Not Found
```
Aucun compte trouvé avec l'identifiant spécifié dans `nationalId`.

### 400 Bad Request - Données invalides
```
PUT /user?nationalId=810001234567
Body: { "nationalId": null }

Response: 400 Bad Request
```
Le corps de la requête contient des données invalides.

## Vérifications importantes

### Avant fusion
1. Le compte existant (`existingId`) doit exister dans MongoDB
2. Le compte existant doit être actif (`deactivated == null`)
3. Le nouveau `nationalId` ne doit pas déjà exister comme compte séparé

### Pendant la fusion
1. L'`_id` MongoDB du compte existant est **préservé**
2. Les deux identifiants sont ajoutés à la liste `ids`
3. Les `alternativeIdentifiers` sont régénérés avec tous les IDs
4. Un `PsRef` est créé pour tracer la fusion

### Après fusion
1. Les deux identifiants pointent vers le **même document** MongoDB
2. Les recherches par l'un ou l'autre identifiant retournent le même compte
3. Le compte a un seul `activated` timestamp (celui du compte original)

## Logs et debugging

### Logs importants à surveiller

**Recherche du compte existant :**
```
Multiple PS found with searchId {}, searching for active one using MongoTemplate
```

**Ajout du nouveau nationalId :**
```
Added nationalId {} to ids list for PS {}
```

**Déclenchement de la fusion :**
```
Found existing PS {} to merge with {}
```

**Préservation des professions :**
```
Preserved existing professions from stored PS for {}
```

## Bonnes pratiques

1. **Toujours spécifier `existingId`** : Ne pas omettre le paramètre `nationalId` (ou `extraId`)
2. **Vérifier l'existence** : S'assurer que le compte existe avant de tenter la fusion
3. **Inclure les alternativeIdentifiers** : Ajouter l'`existingId` dans la liste des identifiants alternatifs
4. **Tester la recherche** : Après fusion, vérifier que les deux identifiants fonctionnent
5. **Logger les opérations** : Tracer toutes les fusions pour audit et debugging

## Références

- **Code source** : `psc-ps-api/src/main/java/fr/ans/psc/delegate/PsApiDelegateImpl.java`
- **Méthode principale** : `updatePs(Ps ps, String existingId)`
- **Service de toggle** : `ToggleApiDelegateImpl.togglePsref(PsRef psRef)`
- **Utilitaires** : `ApiUtils.isValidUUID()`, `ApiUtils.setAppropriateIds()`
