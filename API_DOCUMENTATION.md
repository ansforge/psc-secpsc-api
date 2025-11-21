# Documentation API PSC PSI

## Vue d'ensemble

L'API PSC PSI (ProSanté Connect - Plateforme de Services d'Identité) permet la gestion des utilisateurs dans le système de santé français. Cette API offre des fonctionnalités de recherche, création et mise à jour des utilisateurs.

## 🚀 Démarrage rapide

### Prérequis
- Java 11+
- Maven 3.6+
- MongoDB (optionnel pour certaines fonctionnalités)

### Lancement avec Swagger UI

```bash
# Méthode 1: Utiliser le script de démarrage
./start-with-swagger.sh

# Méthode 2: Démarrage manuel
mvn clean spring-boot:run
```

### Accès à la documentation

- **Spécification OpenAPI**: [openapi-spec.yaml](./openapi-spec.yaml)

## 📋 Endpoints disponibles

### 1. Rechercher un utilisateur par ID national
```http
GET /api/user?nationalId={id}
```

**Exemple:**
```bash
curl "http://localhost:8085/psc-psi-api/api/user?nationalId=12345678901"
```

### 2. Rechercher par traits d'identité
```http
GET /api/user/identitytraits?lastName={nom}&firstNames={prenoms}&genderCode={genre}&birthdate={date}
```

**⚠️ Important : Correspondance Exacte des Prénoms**

Cette API effectue une **correspondance exacte** du nombre, des valeurs ET de l'ordre des prénoms :
- ✅ `firstNames=Jean` → Trouve uniquement les PS avec le prénom "Jean" seul
- ❌ `firstNames=Jean` → Ne trouve PAS "Jean Pierre" ou "Jean Paul"
- ✅ `firstNames=Jean Pierre` → Trouve uniquement les PS avec "Jean" en 1er ET "Pierre" en 2ème
- ❌ `firstNames=Jean Pierre` → Ne trouve PAS "Pierre Jean" (ordre différent)

**Comment ça fonctionne ?**

1. **Recherche initiale** : L'API interroge psc-ps-api qui utilise MongoDB `$all` (recherche inclusive)
2. **Filtrage post-requête** : Chaque résultat candidat est vérifié pour garantir :
   - Même nombre de prénoms
   - Mêmes valeurs de prénoms (sensible à la casse et aux accents)
   - **Même ordre des prénoms** (respecte la position de chaque prénom)
3. **Résultat** : Seuls les PS avec correspondance exacte sont retournés

**Exemples de recherche :**

```bash
# Recherche "Jean" seul (casse exacte)
curl "http://localhost:8085/psc-psi-api/api/user/identitytraits?lastName=Dupont&firstNames=Jean&genderCode=M&birthdate=1980-01-01"
# Retourne : ["11111111111"] (uniquement ceux avec "Jean" exact, pas "jean" ou "JEAN")

# Recherche "jean" minuscule
curl "http://localhost:8085/psc-psi-api/api/user/identitytraits?lastName=Dupont&firstNames=jean&genderCode=M&birthdate=1980-01-01"
# Retourne : [] (aucun résultat si stocké comme "Jean")

# Recherche "Jean Pierre" (dans cet ordre, casse exacte)
curl "http://localhost:8085/psc-psi-api/api/user/identitytraits?lastName=Dupont&firstNames=Jean%20Pierre&genderCode=M&birthdate=1980-01-01"
# Retourne : ["22222222222"] (uniquement ceux avec "Jean" puis "Pierre", casse exacte)

# Recherche "Pierre Jean" (ordre inversé)
curl "http://localhost:8085/psc-psi-api/api/user/identitytraits?lastName=Dupont&firstNames=Pierre%20Jean&genderCode=M&birthdate=1980-01-01"
# Retourne : ["33333333333"] (uniquement ceux avec "Pierre" puis "Jean", PAS "Jean Pierre")

# Recherche "René" avec accent
curl "http://localhost:8085/psc-psi-api/api/user/identitytraits?lastName=Martin&firstNames=René&genderCode=M&birthdate=1975-05-15"
# Retourne : ["44444444444"] (uniquement ceux avec "René", pas "Rene" sans accent)
```

### 3. Créer un utilisateur
```http
POST /api/user
Content-Type: application/json
```

**Exemple:**
```bash
curl -X POST "http://localhost:8085/psc-psi-api/api/user" \
  -H "Content-Type: application/json" \
  -d '{
    "nationalId": "12345678901",
    "civilStatus": {
      "firstName": "Jean",
      "lastName": "Dupont",
      "genderCode": "M",
      "birthDate": "1980-01-01",
      "birthPlace": "Paris"
    },
    "contactInfo": {
      "email": "jean.dupont@example.com",
      "phone": "+33123456789"
    }
  }'
```

### 4. Mettre à jour un utilisateur
```http
PUT /api/user?nationalId={id}
Content-Type: application/json
```

**Exemple:**
```bash
curl -X PUT "http://localhost:8085/psc-psi-api/api/user?nationalId=12345678901" \
  -H "Content-Type: application/json" \
  -d '{
    "nationalId": "12345678901",
    "contactInfo": {
      "email": "nouveau.email@example.com",
      "phone": "+33987654321"
    }
  }'
```

## 📊 Modèles de données

### User
```json
{
  "nationalId": "string (requis)",
  "civilStatus": {
    "firstName": "string",
    "lastName": "string", 
    "genderCode": "M|F",
    "birthDate": "date",
    "birthPlace": "string",
    "birthTownCode": "string",
    "birthCountryCode": "string"
  },
  "contactInfo": {
    "email": "string (email)",
    "phone": "string"
  },
  "practices": [
    {
      "code": "string",
      "description": "string"
    }
  ],
  "alternativeIdentifiers": [
    {
      "type": "string",
      "value": "string"
    }
  ]
}
```

## 🔧 Configuration

### Application Properties
```properties
# Serveur
server.port=8085
server.servlet.context-path=/psc-psi-api

# SpringDoc OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true
springdoc.api-docs.enabled=true

# APIs externes
openapi.pscApiMajV2.base-path=http://localhost:8080/psc-api-maj/api
openapi.pscAmar.base-path=http://localhost:3000/
```

## 📝 Codes de retour HTTP

| Code | Description |
|------|-------------|
| 200  | Succès |
| 201  | Créé avec succès |
| 400  | Données invalides ou absentes |
| 401  | Utilisateur non autorisé |
| 404  | Utilisateur non trouvé |
| 409  | Conflit (utilisateur existe déjà) |
| 500  | Erreur interne serveur |

## 🔍 Dépannage

### L'application ne démarre pas
1. Vérifiez que Java 11+ est installé : `java -version`
2. Vérifiez que Maven est installé : `mvn -version`
3. Vérifiez que le port 8085 est libre : `lsof -i :8085`

### Erreurs d'authentification
Les APIs externes (PSC et AMAR) doivent être configurées et accessibles.

## � Détails Techniques : Correspondance Exacte des Prénoms

### Problématique

L'API psc-ps-api utilise l'opérateur MongoDB `$all` qui effectue une recherche **inclusive** :
- Recherche "Jean" → Retourne "Jean", "Jean Pierre", "Jean Paul", etc.
- Cela peut créer des ambiguïtés pour le système SEC PSC

### Solution Implémentée

psc-secpsc-api applique un **filtrage post-requête** pour garantir une correspondance exacte :

#### Algorithme de Filtrage

```java
// 1. Conversion de la chaîne en liste (ordre préservé)
"Jean Pierre" → ["Jean", "Pierre"]

// 2. Requête psc-ps-api (recherche inclusive)
GET /v2/ps/search?firstNames=Jean%20Pierre
→ Retourne tous les candidats contenant "Jean" ET "Pierre" (peu importe l'ordre)

// 3. Pour chaque candidat, vérification de correspondance exacte
Pour chaque nationalId retourné :
  - Récupérer le PS complet (GET /v2/ps/{nationalId})
  - Extraire ses prénoms réels (triés par le champ 'order')
  - Vérifier :
    ✓ Même nombre de prénoms
    ✓ Mêmes valeurs (sensible à la casse et aux accents)
    ✓ Même ordre (position par position)
  - Si correspondance exacte → Garder
  - Sinon → Filtrer

// 4. Retour des IDs avec correspondance exacte uniquement
```

#### Exemple de Filtrage

**Base de données** :
- PS1 : `firstNames = [{"firstName":"Jean", "order":1}]`
- PS2 : `firstNames = [{"firstName":"Jean", "order":1}, {"firstName":"Pierre", "order":2}]`
- PS3 : `firstNames = [{"firstName":"Pierre", "order":1}, {"firstName":"Jean", "order":2}]`

**Recherche 1** : `firstNames=Jean`

1. **psc-ps-api retourne** : `["PS1", "PS2", "PS3"]` (tous contiennent "Jean")
2. **Filtrage psc-secpsc-api** :
   - PS1 : 1 prénom = 1 cherché, "Jean" = "Jean" ✅ → **GARDÉ**
   - PS2 : 2 prénoms ≠ 1 cherché ❌ → FILTRÉ
   - PS3 : 2 prénoms ≠ 1 cherché ❌ → FILTRÉ
3. **Résultat final** : `["PS1"]`

**Recherche 2** : `firstNames=Jean Pierre`

1. **psc-ps-api retourne** : `["PS2", "PS3"]` (tous contiennent "Jean" ET "Pierre")
2. **Filtrage psc-secpsc-api** :
   - PS2 : 2 prénoms = 2 cherchés, ["Jean", "Pierre"] = ["Jean", "Pierre"] ✅ → **GARDÉ**
   - PS3 : 2 prénoms = 2 cherchés, ["Pierre", "Jean"] ≠ ["Jean", "Pierre"] ❌ → **FILTRÉ** (ordre différent)
3. **Résultat final** : `["PS2"]`

**Recherche 3** : `firstNames=Pierre Jean`

1. **psc-ps-api retourne** : `["PS2", "PS3"]` (tous contiennent "Pierre" ET "Jean")
2. **Filtrage psc-secpsc-api** :
   - PS2 : ["Jean", "Pierre"] ≠ ["Pierre", "Jean"] ❌ → FILTRÉ
   - PS3 : ["Pierre", "Jean"] = ["Pierre", "Jean"] ✅ → **GARDÉ**
3. **Résultat final** : `["PS3"]`

**Recherche 4** : `firstNames=jean` (minuscule)

1. **psc-ps-api retourne** : `["PS1", "PS2", "PS3"]` (insensible à la casse pour MongoDB)
2. **Filtrage psc-secpsc-api** :
   - PS1 : "Jean" ≠ "jean" ❌ → **FILTRÉ** (casse différente)
   - PS2 : "Jean" ≠ "jean" ❌ → FILTRÉ
   - PS3 : "Pierre" ≠ "jean" ❌ → FILTRÉ
3. **Résultat final** : `[]` (aucune correspondance exacte)

### Performance

⚠️ **Impact Performance** :
- Un appel API supplémentaire est effectué pour **chaque candidat** retourné par psc-ps-api
- Si 10 candidats → 10 appels GET `/v2/ps/{id}`
- Pour optimiser : utiliser des noms plus précis ou ajouter des critères optionnels (birthTownCode, birthCountryCode)

### Logs de Debug

Pour activer les logs détaillés du filtrage :

```properties
logging.level.org.openapitools.api.PsiApiController=DEBUG
```

Logs générés :
```
DEBUG - Searched firstNames as list: [Jean, Pierre]
DEBUG - Candidate IDs from ps-api: [11111111111, 22222222222, 33333333333]
DEBUG - PS firstNames (ordered): [Jean, Pierre], Searched firstNames: [Jean, Pierre]
DEBUG - Exact match with order respected: true
DEBUG - Exact match found for nationalId: 22222222222
DEBUG - PS firstNames (ordered): [Jean], Searched firstNames: [Jean, Pierre]
DEBUG - Different number of firstNames: PS has 1, search has 2
DEBUG - Filtered out nationalId 11111111111 (firstNames don't match exactly)
DEBUG - PS firstNames (ordered): [Pierre, Jean], Searched firstNames: [Jean, Pierre]
DEBUG - FirstName mismatch at position 0: PS has 'Pierre', search has 'Jean'
DEBUG - Filtered out nationalId 33333333333 (firstNames don't match exactly)
INFO  - Exact match IDs after filtering: [22222222222]
```

### Alternative Future

Si psc-ps-api ajoute un paramètre `exactMatch=true` dans son endpoint `/v2/ps/search`, le filtrage post-requête ne sera plus nécessaire et les performances seront améliorées.

## �📚 Ressources supplémentaires

- [SpringDoc OpenAPI Documentation](https://springdoc.org/)
- [OpenAPI Specification](https://swagger.io/specification/)
- [ANS - Agence du Numérique en Santé](https://esante.gouv.fr)
