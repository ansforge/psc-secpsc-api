# 🧪 Guide de Test - Correspondance Exacte des Prénoms

## 📋 Prérequis

### Services nécessaires
1. **psc-ps-api** : Doit tourner sur `http://localhost:8080/psc-api-maj/api`
2. **MongoDB** : Doit tourner sur `localhost:27017` avec la base `psc-mongodb`
3. **psc-amar-connector** (optionnel) : Sur `http://localhost:3000/`

### Données de test en base
Vous devez avoir dans MongoDB des PS avec différents prénoms :

```javascript
// PS1 - Prénom simple
{
  "nationalId": "11111111111",
  "firstName": "Jean",
  "firstNames": [
    {"firstName": "Jean", "order": 1}
  ],
  "lastName": "Dupont",
  "birthdate": "1980-01-01"
}

// PS2 - Prénom composé
{
  "nationalId": "22222222222",
  "firstName": "Jean",
  "firstNames": [
    {"firstName": "Jean", "order": 1},
    {"firstName": "Pierre", "order": 2}
  ],
  "lastName": "Dupont",
  "birthdate": "1980-01-01"
}

// PS3 - Prénom composé ordre inversé
{
  "nationalId": "33333333333",
  "firstName": "Pierre",
  "firstNames": [
    {"firstName": "Pierre", "order": 1},
    {"firstName": "Jean", "order": 2}
  ],
  "lastName": "Dupont",
  "birthdate": "1980-01-01"
}

// PS4 - Prénom minuscule
{
  "nationalId": "44444444444",
  "firstName": "jean",
  "firstNames": [
    {"firstName": "jean", "order": 1}
  ],
  "lastName": "Dupont",
  "birthdate": "1980-01-01"
}

// PS5 - Prénom avec accent
{
  "nationalId": "55555555555",
  "firstName": "René",
  "firstNames": [
    {"firstName": "René", "order": 1}
  ],
  "lastName": "Martin",
  "birthdate": "1975-05-15"
}

// PS6 - Prénom sans accent
{
  "nationalId": "66666666666",
  "firstName": "Rene",
  "firstNames": [
    {"firstName": "Rene", "order": 1}
  ],
  "lastName": "Martin",
  "birthdate": "1975-05-15"
}
```

---

## 🚀 Étape 1 : Compilation

```bash
cd /Users/gaultiermoraillon/ANS/SEC-PSC/psc-secpsc-api
mvn clean install
```

**Résultat attendu** : `BUILD SUCCESS`

---

## 🚀 Étape 2 : Démarrage de l'application

### Option A : Avec Maven
```bash
mvn spring-boot:run
```

### Option B : Avec le JAR
```bash
java -jar target/psc-secpsc-api-*.jar
```

### Option C : Avec logs DEBUG activés
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--logging.level.org.openapitools.api.PsiApiController=DEBUG"
```

**Vérification** : L'application démarre sur `http://localhost:8085/psc-secpsc-api`

---

## 🧪 Étape 3 : Tests Manuels

### Test 1 : Prénom simple exact (casse correcte)
```bash
curl -X GET "http://localhost:8085/psc-secpsc-api/api/user/identitytraits?lastName=Dupont&firstNames=Jean&genderCode=M&birthdate=1980-01-01"
```

**Résultat attendu** :
```json
["11111111111"]
```
✅ Retourne uniquement PS1 (Jean seul, casse correcte)

---

### Test 2 : Prénom simple avec mauvaise casse
```bash
curl -X GET "http://localhost:8085/psc-secpsc-api/api/user/identitytraits?lastName=Dupont&firstNames=jean&genderCode=M&birthdate=1980-01-01"
```

**Résultat attendu** :
```json
["44444444444"]
```
✅ Retourne uniquement PS4 ("jean" minuscule), PAS PS1 ("Jean")

---

### Test 3 : Prénom composé exact
```bash
curl -X GET "http://localhost:8085/psc-secpsc-api/api/user/identitytraits?lastName=Dupont&firstNames=Jean%20Pierre&genderCode=M&birthdate=1980-01-01"
```

**Résultat attendu** :
```json
["22222222222"]
```
✅ Retourne uniquement PS2 (Jean Pierre dans cet ordre)

---

### Test 4 : Prénom composé ordre inversé
```bash
curl -X GET "http://localhost:8085/psc-secpsc-api/api/user/identitytraits?lastName=Dupont&firstNames=Pierre%20Jean&genderCode=M&birthdate=1980-01-01"
```

**Résultat attendu** :
```json
["33333333333"]
```
✅ Retourne uniquement PS3 (Pierre Jean), PAS PS2

---

### Test 5 : Prénom avec accent exact
```bash
curl -X GET "http://localhost:8085/psc-secpsc-api/api/user/identitytraits?lastName=Martin&firstNames=René&genderCode=M&birthdate=1975-05-15"
```

**Résultat attendu** :
```json
["55555555555"]
```
✅ Retourne uniquement PS5 (René avec accent)

---

### Test 6 : Prénom sans accent (ne doit pas matcher avec accent)
```bash
curl -X GET "http://localhost:8085/psc-secpsc-api/api/user/identitytraits?lastName=Martin&firstNames=Rene&genderCode=M&birthdate=1975-05-15"
```

**Résultat attendu** :
```json
["66666666666"]
```
✅ Retourne uniquement PS6 (Rene sans accent), PAS PS5

---

### Test 7 : Prénom simple ne doit pas matcher composé
```bash
curl -X GET "http://localhost:8085/psc-secpsc-api/api/user/identitytraits?lastName=Dupont&firstNames=Jean&genderCode=M&birthdate=1980-01-01"
```

**Résultat attendu** :
```json
["11111111111"]
```
✅ Ne retourne PAS PS2 (Jean Pierre) ni PS3 (Pierre Jean)

---

## 📊 Étape 4 : Analyse des Logs DEBUG

### Activer les logs DEBUG
Ajouter dans `application.properties` :
```properties
logging.level.org.openapitools.api.PsiApiController=DEBUG
```

Ou au démarrage :
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--logging.level.org.openapitools.api.PsiApiController=DEBUG"
```

### Logs attendus pour Test 3 (Jean Pierre)
```
DEBUG - Searched firstNames as list: [Jean, Pierre]
DEBUG - Candidate IDs from ps-api: [11111111111, 22222222222, 33333333333]
DEBUG - PS firstNames (ordered): [Jean], Searched firstNames: [Jean, Pierre]
DEBUG - Different number of firstNames: PS has 1, search has 2
DEBUG - Filtered out nationalId 11111111111 (firstNames don't match exactly)
DEBUG - PS firstNames (ordered): [Jean, Pierre], Searched firstNames: [Jean, Pierre]
DEBUG - Exact match with order respected: true
DEBUG - Exact match found for nationalId: 22222222222
DEBUG - PS firstNames (ordered): [Pierre, Jean], Searched firstNames: [Jean, Pierre]
DEBUG - FirstName mismatch at position 0: PS has 'Pierre', search has 'Jean'
DEBUG - Filtered out nationalId 33333333333 (firstNames don't match exactly)
INFO  - Exact match IDs after filtering: [22222222222]
```

---

## 🧪 Étape 5 : Tests Unitaires

### Créer un test unitaire
Créer le fichier : `src/test/java/org/openapitools/api/PsiApiControllerTest.java`

```java
package org.openapitools.api;

import fr.ans.psc.model.Ps;
import fr.ans.psc.model.FirstName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PsiApiControllerTest {

    private PsiApiController controller;
    private Method hasExactFirstNamesMatchMethod;

    @BeforeEach
    void setUp() throws Exception {
        controller = new PsiApiController();
        // Accès à la méthode privée pour les tests
        hasExactFirstNamesMatchMethod = PsiApiController.class
            .getDeclaredMethod("hasExactFirstNamesMatch", Ps.class, List.class);
        hasExactFirstNamesMatchMethod.setAccessible(true);
    }

    private boolean callHasExactFirstNamesMatch(Ps ps, List<String> searchedNames) throws Exception {
        return (boolean) hasExactFirstNamesMatchMethod.invoke(controller, ps, searchedNames);
    }

    @Test
    void testExactMatch_SimpleFirstName() throws Exception {
        Ps ps = new Ps();
        FirstName fn = new FirstName();
        fn.setFirstName("Jean");
        fn.setOrder(1);
        ps.setFirstNames(Arrays.asList(fn));

        assertTrue(callHasExactFirstNamesMatch(ps, Arrays.asList("Jean")));
    }

    @Test
    void testNoMatch_CaseSensitive() throws Exception {
        Ps ps = new Ps();
        FirstName fn = new FirstName();
        fn.setFirstName("Jean");
        fn.setOrder(1);
        ps.setFirstNames(Arrays.asList(fn));

        assertFalse(callHasExactFirstNamesMatch(ps, Arrays.asList("jean")));
        assertFalse(callHasExactFirstNamesMatch(ps, Arrays.asList("JEAN")));
    }

    @Test
    void testNoMatch_AccentSensitive() throws Exception {
        Ps ps = new Ps();
        FirstName fn = new FirstName();
        fn.setFirstName("René");
        fn.setOrder(1);
        ps.setFirstNames(Arrays.asList(fn));

        assertFalse(callHasExactFirstNamesMatch(ps, Arrays.asList("Rene")));
    }

    @Test
    void testExactMatch_ComposedFirstName() throws Exception {
        Ps ps = new Ps();
        FirstName fn1 = new FirstName();
        fn1.setFirstName("Jean");
        fn1.setOrder(1);
        FirstName fn2 = new FirstName();
        fn2.setFirstName("Pierre");
        fn2.setOrder(2);
        ps.setFirstNames(Arrays.asList(fn1, fn2));

        assertTrue(callHasExactFirstNamesMatch(ps, Arrays.asList("Jean", "Pierre")));
    }

    @Test
    void testNoMatch_DifferentOrder() throws Exception {
        Ps ps = new Ps();
        FirstName fn1 = new FirstName();
        fn1.setFirstName("Jean");
        fn1.setOrder(1);
        FirstName fn2 = new FirstName();
        fn2.setFirstName("Pierre");
        fn2.setOrder(2);
        ps.setFirstNames(Arrays.asList(fn1, fn2));

        assertFalse(callHasExactFirstNamesMatch(ps, Arrays.asList("Pierre", "Jean")));
    }

    @Test
    void testNoMatch_DifferentCount() throws Exception {
        Ps ps = new Ps();
        FirstName fn = new FirstName();
        fn.setFirstName("Jean");
        fn.setOrder(1);
        ps.setFirstNames(Arrays.asList(fn));

        assertFalse(callHasExactFirstNamesMatch(ps, Arrays.asList("Jean", "Pierre")));
    }

    @Test
    void testNoMatch_SimpleVsComposed() throws Exception {
        Ps ps = new Ps();
        FirstName fn1 = new FirstName();
        fn1.setFirstName("Jean");
        fn1.setOrder(1);
        FirstName fn2 = new FirstName();
        fn2.setFirstName("Pierre");
        fn2.setOrder(2);
        ps.setFirstNames(Arrays.asList(fn1, fn2));

        assertFalse(callHasExactFirstNamesMatch(ps, Arrays.asList("Jean")));
    }
}
```

### Lancer les tests
```bash
mvn test
```

**Résultat attendu** : `Tests run: 7, Failures: 0, Errors: 0, Skipped: 0`

---

## 📋 Matrice de Validation

| Test | Recherche | Base | Résultat Attendu | Statut |
|------|-----------|------|------------------|--------|
| 1 | `Jean` | `["Jean"]` | ✅ Match | ⬜ |
| 2 | `jean` | `["Jean"]` | ❌ Pas de match | ⬜ |
| 3 | `jean` | `["jean"]` | ✅ Match | ⬜ |
| 4 | `Jean Pierre` | `["Jean", "Pierre"]` | ✅ Match | ⬜ |
| 5 | `Pierre Jean` | `["Jean", "Pierre"]` | ❌ Pas de match | ⬜ |
| 6 | `Jean` | `["Jean", "Pierre"]` | ❌ Pas de match | ⬜ |
| 7 | `René` | `["René"]` | ✅ Match | ⬜ |
| 8 | `Rene` | `["René"]` | ❌ Pas de match | ⬜ |

---

## 🐛 Dépannage

### Problème : L'application ne démarre pas
```bash
# Vérifier que le port 8085 est libre
lsof -i :8085

# Vérifier Java
java -version  # Doit être Java 11+
```

### Problème : Erreur de connexion à psc-ps-api
```bash
# Vérifier que psc-ps-api tourne
curl http://localhost:8080/psc-api-maj/api/v2/ps/search

# Si besoin, modifier dans application.properties :
openapi.pscApiMajV2.base-path=http://AUTRE_URL/api
```

### Problème : Pas de résultats alors qu'attendus
1. Activer les logs DEBUG
2. Vérifier que les données sont bien en base MongoDB
3. Vérifier que psc-ps-api retourne des candidats
4. Analyser les logs de filtrage

---

## ✅ Checklist de Validation

- [ ] Compilation réussie (`mvn clean install`)
- [ ] Application démarre sans erreur
- [ ] Test 1 : Casse exacte fonctionne
- [ ] Test 2 : Casse différente filtrée
- [ ] Test 3 : Prénom composé exact fonctionne
- [ ] Test 4 : Ordre inversé filtré
- [ ] Test 5 : Accent exact fonctionne
- [ ] Test 6 : Sans accent ne match pas avec accent
- [ ] Test 7 : Simple ne match pas composé
- [ ] Logs DEBUG affichent le détail du filtrage
- [ ] Tests unitaires passent (si créés)

---

## 📦 Déploiement en Qualification

Une fois validé localement :

```bash
# Build de l'image Docker
cd /Users/gaultiermoraillon/ANS/SEC-PSC/psc-secpsc-api
docker build -t psc-secpsc-api:latest .

# Tag et push vers le registry
docker tag psc-secpsc-api:latest REGISTRY_URL/psc-secpsc-api:v3-exact-match
docker push REGISTRY_URL/psc-secpsc-api:v3-exact-match
```

Puis déployer avec Nomad/Waypoint selon votre infrastructure.
