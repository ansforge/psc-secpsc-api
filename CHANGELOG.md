# Changelog — psc-secpsc-api

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
