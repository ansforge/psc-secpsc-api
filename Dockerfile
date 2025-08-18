FROM maven:3-jdk-11 AS build
COPY settings-docker.xml /usr/share/maven/ref/
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
ARG PROSANTECONNECT_PACKAGE_GITHUB_TOKEN
RUN mvn -f /usr/src/app/pom.xml -gs /usr/share/maven/ref/settings-docker.xml -Dinternal.repo.username=${PROSANTECONNECT_PACKAGE_GITHUB_TOKEN} -Dextract.test.name=Extraction_Pro_sante_connect_cartes_de_test_bascule -DskipTests clean package

FROM openjdk:11-slim-buster
COPY --from=build /usr/src/app/target/psc-psi-api-*.jar /usr/app/psc-psi-api.jar
USER daemon
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/psc-psi-api.jar"]
