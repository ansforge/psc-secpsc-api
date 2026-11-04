# Changelog — psc-secpsc-api

## [2026-07-02]

### Ajouté

#### mTLS pour les appels AMAR (INGROUP)
- Authentification par certificat client (mTLS) sur les appels sortants vers l'API AMAR, exigée par la plateforme INGROUP (sans quoi : `403 Forbidden — Missing certificate`).
- Nouvelle classe `AmarMtlsSslContextFactory` : charge le certificat client + clé au format PEM (clé PKCS#8, chargement pur JDK sans BouncyCastle) et construit un `SSLContext` injecté par client dans le `RestTemplate`. Pas de truststore custom (serveur AMAR sur AC publique). Timeouts connect/read posés sur l'appel externe.
- Activation optionnelle : sans certificat configuré (dev local), les appels restent en TLS simple.

### Modifié

#### `RestTemplateConfig`
- `eimsApi()` présente désormais le certificat client mTLS (via une request factory dédiée) lorsque `amar.cert.path` / `amar.key.path` sont configurés ; sinon comportement inchangé.

#### Configuration / déploiement
- Nouvelles propriétés `amar.cert.path` / `amar.key.path`.
- `psc-secpsc-api.nomad.tpl` : certificat client provisionné via Vault (`amar_client_certificate` / `amar_client_private_key`) et rendu dans `/secrets/amar-cert.pem` et `/secrets/amar-key.pem`.

---

## [2026-04-29]

### Ajouté

#### `CivilStatusDto`
- Champ `usualLastName` (nom d'usage / marital). À la création d'un user, si non fourni → fallback sur `lastName`.

#### `PUT /user/activity` (`upsertUserActivity`)
- Nouvel endpoint : ajoute ou remplace une practice unique identifiée par son `sourceId`. Passthrough vers `PUT /v2/ps/{psId}/activity` côté psc-ps-api.
- Paramètres : `nationalId` (query, required) ; body : `PracticeDto` avec `sourceId` mandatory.
- Réponses : `200` si OK, `400` si `sourceId` manquant ou invalide, `410` si PS introuvable.

#### Adapters
- `PsiPsAdapter` propage `civilStatus.usualLastName → Ps.usualLastName`.
- `PsiCivilStatusAdapter` (reverse pour GET) propage `Ps.usualLastName → CivilStatusDto.usualLastName`.
- `PsiProfessionAdapter` propage `Practice.sourceId → Profession.sourceId` (encodé via `AttributeEncoding.encodeStringAttribute`).

### Modifié

#### `pom.xml`
- Bump dépendance `amar-api-client 2.0.0 → 2.0.1` (pour les nouveaux champs `usualLastName` sur `CivilStatus` et `sourceId` sur `Practice`).

### Corrigé

#### `convertUserDtoToUser` (création / update User)
- Bug : 14 champs d'`ActivityDto` n'étaient pas mappés vers AMAR `Activity` lors d'un POST/PUT, ce qui les faisait disparaître au round-trip GET. Champs ajoutés : `companyAdditionalAddress`, `companyTechnicalIdentifier`, `companyAddressType`, `companyStreetCategory`, `companyStreet`, `companyDistributionMention`, `companyOldStructureNumber`, `companySIRET`, `companySIREN`, `companyCommuneCode`, `companyDepartmentCode`, `companyCountryCode`, `companyMainEmail`, `companyOldStructureId`.
- Refactor : extraction d'une méthode privée `convertPracticeDtoToPractice` réutilisée par le nouvel endpoint `upsertUserActivity`.

---

## [2026-03-31]

### Modifié

#### `GET /user/search` (`rechercherParNomPrenom`)
- La réponse retourne désormais une liste enrichie avec, pour chaque PS trouvé :
  - `nationalId` : identifiant national
  - `companyNames` : liste d'objets `WorkLocationDto` (au lieu d'une liste de chaînes), chaque objet contenant :
    - `professionCode` : code de la profession
    - `companyName` : raison sociale de la structure
    - `companyCedexOffice` : code cedex de la structure

#### `openapi-spec.yaml`
- Schéma `PsNameSearchResultDto` mis à jour : `companyNames` passe de `array of string` à `array of WorkLocationDto`
- Ajout du schéma `WorkLocationDto`

#### `GET /user` (`rechercherParIdNational`)
- Ajout du paramètre optionnel `includeDeactivated` (boolean, défaut `false`)
- Quand `true`, retourne le compte même s'il est désactivé (proxifié vers `psc-ps-api GET /v2/ps/{nationalId}?includeDeactivated=true`)

### Ajouté
- `org.openapitools.model.WorkLocationDto` — DTO exposé dans la réponse `/user/search`
- `org.openapitools.model.PsSearchResultFromPsApiDto` — DTO interne pour désérialiser la réponse de `psc-ps-api /v2/ps/search/name`
