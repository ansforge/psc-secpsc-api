# Changelog : Correspondance Exacte des Prénoms

## 📅 Date : 14 novembre 2025

## 🎯 Objectif

Modifier le endpoint `GET /user/identitytraits` pour retourner **uniquement** les professionnels de santé dont les prénoms correspondent **exactement** à la recherche.

## ❌ Comportement Avant

### Problème
L'API psc-ps-api utilise MongoDB `$all` qui effectue une recherche inclusive :
- Recherche `firstNames=Jean` → Retournait "Jean", "Jean Pierre", "Jean Paul", etc.
- Créait des ambiguïtés pour le système SEC PSC

### Exemple
```bash
# Base de données
PS1: firstNames = ["Jean"]
PS2: firstNames = ["Jean", "Pierre"]

# Recherche
GET /user/identitytraits?firstNames=Jean&...

# Résultat AVANT
["PS1", "PS2"]  ❌ Les deux retournés
```

## ✅ Comportement Après

### Solution
Filtrage post-requête dans `PsiApiController` pour garantir une correspondance exacte :
1. Appel à psc-ps-api (recherche inclusive)
2. Pour chaque candidat, vérification :
   - Même nombre de prénoms
   - Mêmes valeurs (insensible casse et ordre)
3. Retour uniquement des correspondances exactes

### Exemple
```bash
# Même base de données et recherche

# Résultat APRÈS
["PS1"]  ✅ Seul "Jean" seul retourné
```

## 🔧 Modifications Techniques

### Fichier Modifié
`psc-secpsc-api/src/main/java/org/openapitools/api/PsiApiController.java`

### Méthodes Ajoutées

#### 1. `hasExactFirstNamesMatch(Ps ps, List<String> searchedFirstNames)`
```java
/**
 * Vérifie si les prénoms d'un PS correspondent exactement aux prénoms recherchés
 * - Même nombre de prénoms
 * - Mêmes valeurs (insensible à la casse)
 * - Même ordre (position par position)
 */
private boolean hasExactFirstNamesMatch(Ps ps, List<String> searchedFirstNames)
```

**Logique v1** (ordre insensible) :
- Extraction des prénoms du PS
- Vérification du nombre identique
- Comparaison triée et en majuscules

**Logique v2** (ordre strict) :
- Extraction des prénoms du PS **triés par le champ `order`**
- Vérification du nombre identique
- **Comparaison position par position** (insensible à la casse uniquement)

**Logique v3** (sensibilité complète) :
- Extraction des prénoms du PS **triés par le champ `order`**
- Vérification du nombre identique
- **Comparaison position par position stricte** (sensible à la casse ET aux accents)
- "Jean" ≠ "jean", "René" ≠ "Rene"

### Méthode Modifiée

#### `rechercherNationalIdParTraitsIdentite(...)`

**Ajouts** :
1. Conversion des prénoms recherchés en liste
2. Récupération des IDs candidats depuis psc-ps-api
3. Boucle de filtrage :
   - Appel GET `/v2/ps/{nationalId}` pour chaque candidat
   - Vérification de correspondance exacte
   - Conservation uniquement si match exact
4. Retour de la liste filtrée

## 📊 Matrice de Résultats

| Base de données | Recherche | AVANT | APRÈS (v1) | APRÈS (v2 ordre) | APRÈS (v3 casse) |
|-----------------|-----------|-------|------------|------------------|------------------|
| `["Jean"]` | `Jean` | ✅ Trouvé | ✅ Trouvé | ✅ Trouvé | ✅ Trouvé |
| `["Jean"]` | `jean` | ✅ Trouvé | ✅ Trouvé | ✅ Trouvé | ❌ Filtré (casse) |
| `["Jean", "Pierre"]` | `Jean` | ⚠️ Trouvé | ❌ Filtré | ❌ Filtré | ❌ Filtré |
| `["Jean", "Pierre"]` | `Jean Pierre` | ✅ Trouvé | ✅ Trouvé | ✅ Trouvé | ✅ Trouvé |
| `["Jean", "Pierre"]` | `jean pierre` | ✅ Trouvé | ✅ Trouvé | ✅ Trouvé | ❌ Filtré (casse) |
| `["Jean", "Pierre"]` | `Pierre Jean` | ✅ Trouvé | ⚠️ Trouvé | ❌ Filtré (ordre) | ❌ Filtré (ordre) |
| `["Pierre", "Jean"]` | `Jean Pierre` | ✅ Trouvé | ⚠️ Trouvé | ❌ Filtré (ordre) | ❌ Filtré (ordre) |
| `["Pierre", "Jean"]` | `Pierre Jean` | ✅ Trouvé | ✅ Trouvé | ✅ Trouvé | ✅ Trouvé |
| `["René"]` | `Rene` | ✅ Trouvé | ✅ Trouvé | ✅ Trouvé | ❌ Filtré (accent) |
| `["Jean", "Paul"]` | `Jean Pierre` | ❌ Non trouvé | ❌ Non trouvé | ❌ Non trouvé | ❌ Non trouvé |

### 🔄 Évolution v2 : Respect de l'Ordre

**Modification supplémentaire (14 nov 2025)** : Ajout de la vérification de l'ordre des prénoms.

**Avant v2** :
- `["Jean", "Pierre"]` matchait `"Pierre Jean"` ⚠️

**Après v2** :
- `["Jean", "Pierre"]` matche **uniquement** `"Jean Pierre"` ✅
- L'ordre des prénoms doit être strictement respecté

### 🔄 Évolution v3 : Sensibilité Casse et Accents

**Modification supplémentaire (14 nov 2025)** : Ajout de la sensibilité à la casse et aux accents.

**Avant v3** :
- `"Jean"` matchait `"jean"` et `"JEAN"` ⚠️
- `"René"` matchait `"Rene"` et `"RENE"` ⚠️

**Après v3** :
- `"Jean"` matche **uniquement** `"Jean"` ✅
- `"René"` matche **uniquement** `"René"` ✅
- Sensibilité complète : casse, accents ET ordre respectés

## ⚠️ Impact Performance

### Coût
- **Appels API supplémentaires** : 1 GET `/v2/ps/{id}` par candidat retourné
- Si 10 candidats → 10 appels HTTP

### Optimisation Recommandée
Pour limiter le nombre de candidats :
1. Utiliser des noms complets précis
2. Ajouter des critères optionnels (birthTownCode, birthCountryCode, birthplace)
3. Activer les logs DEBUG pour analyser

### Exemple d'Optimisation
```bash
# Requête générique (peut retourner beaucoup de candidats)
GET /user/identitytraits?lastName=Dupont&firstNames=Jean&genderCode=M&birthdate=1980-01-01

# Requête optimisée (moins de candidats)
GET /user/identitytraits?lastName=Dupont&firstNames=Jean&genderCode=M&birthdate=1980-01-01&birthTownCode=75001&birthCountryCode=FR
```

## 🧪 Tests Recommandés

### Cas de Test

1. **Test Prénom Simple**
   ```bash
   GET /user/identitytraits?lastName=Dupont&firstNames=Jean&...
   # Doit retourner uniquement les "Jean" (pas "Jean Pierre")
   ```

2. **Test Prénom Composé**
   ```bash
   GET /user/identitytraits?firstNames=Jean%20Pierre&...
   # Doit retourner uniquement les "Jean Pierre" (pas "Jean" seul)
   ```

3. **Test Ordre Inversé**
   ```bash
   GET /user/identitytraits?firstNames=Pierre%20Jean&...
   # Doit retourner uniquement les "Pierre Jean" (PAS "Jean Pierre")
   ```

4. **Test Casse Différente (v3)**
   ```bash
   GET /user/identitytraits?firstNames=jean%20pierre&...
   # NE doit PAS retourner "Jean Pierre" (casse sensible)
   ```

5. **Test Accent Différent (v3)**
   ```bash
   GET /user/identitytraits?firstNames=Rene&...
   # NE doit PAS retourner "René" (accent sensible)
   ```

## 📝 Logs de Debug

Pour activer :
```properties
logging.level.org.openapitools.api.PsiApiController=DEBUG
```

Exemple de sortie :
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

## 🔮 Évolution Future

### Option 1 : Amélioration psc-ps-api
Ajouter un paramètre `exactMatch=true` dans `/v2/ps/search` :
```
GET /v2/ps/search?firstNames=Jean&exactMatch=true
```
→ Éliminerait le besoin de filtrage post-requête

### Option 2 : Cache des PS
Implémenter un cache Redis pour les PS récemment récupérés :
→ Réduirait les appels GET `/v2/ps/{id}` répétés

### Option 3 : Requête MongoDB Directe
Si psc-secpsc-api a accès direct à MongoDB :
→ Requête unique avec critères exacts

## ✅ Validation

- [x] Code implémenté
- [x] Documentation API mise à jour
- [x] Logs de debug ajoutés
- [ ] Tests unitaires à ajouter
- [ ] Tests d'intégration à exécuter
- [ ] Validation en environnement de qualification

## 👥 Auteurs
- Développement : [Votre Nom]
- Validation : [À compléter]
- Date : 14 novembre 2025
