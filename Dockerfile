# ---------- Build Stage ----------
FROM maven:3-jdk-11 AS build

# Argument reçu au moment du build (via --build-arg)
ARG PROSANTECONNECT_PACKAGE_GITHUB_TOKEN
# Mapping ARG → ENV pour que ce soit utilisable dans tous les RUN
ENV GITHUB_TOKEN=${PROSANTECONNECT_PACKAGE_GITHUB_TOKEN}

# Maven settings (avec placeholder ${github.token})
COPY settings-docker.xml /usr/share/maven/ref/settings-docker.xml

WORKDIR /usr/src/app

# Étape 1 : copier seulement le pom.xml pour optimiser le cache des dépendances
COPY pom.xml .
RUN mvn -gs /usr/share/maven/ref/settings-docker.xml \
    -Dgithub.token=${GITHUB_TOKEN} \
    dependency:go-offline

# Étape 2 : copier le code source
COPY src ./src

# Étape 3 : build de l’application
RUN mvn -gs /usr/share/maven/ref/settings-docker.xml \
    -Dgithub.token=${GITHUB_TOKEN} \
    -DskipTests clean package spring-boot:repackage

# ---------- Runtime Stage ----------
FROM openjdk:11-slim-buster

WORKDIR /usr/app

# Copie du jar depuis la phase build
COPY --from=build /usr/src/app/target/psc-psi-api-*.jar ./psc-psi-api.jar

# Utilisateur non-root
USER daemon

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/psc-psi-api.jar"]
