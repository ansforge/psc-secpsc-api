FROM maven:3-jdk-11 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
COPY .openapi-generator-ignore /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package spring-boot:repackage -DskipTests
FROM openjdk:11-slim-buster
# Copy jar from build stage
COPY --from=build /usr/src/app/target/psc-psi-api-*.jar /usr/app/psc-psi-api.jar
# Configure container
USER daemon
EXPOSE 8080
# Run application
ENTRYPOINT ["java","-jar","/usr/app/psc-psi-api.jar"]
