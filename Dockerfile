FROM maven:3.8.4-openjdk-17-slim AS BUILD

WORKDIR /build
COPY pom.xml /build/
COPY src/main/java /build/src/main/java/

RUN mvn clean package -DskipTests

### Copy JAR into container
FROM openjdk:17.0.1-slim-buster
WORKDIR /app

COPY --from=BUILD /build/target/*.jar /app/demo.jar

ENTRYPOINT ["java", "-jar", "demo.jar"]