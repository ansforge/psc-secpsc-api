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

**Exemple:**
```bash
curl "http://localhost:8085/psc-psi-api/api/user/identitytraits?lastName=Dupont&firstNames=Jean&genderCode=M&birthdate=1980-01-01"
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

## 📚 Ressources supplémentaires

- [SpringDoc OpenAPI Documentation](https://springdoc.org/)
- [OpenAPI Specification](https://swagger.io/specification/)
- [ANS - Agence du Numérique en Santé](https://esante.gouv.fr)
