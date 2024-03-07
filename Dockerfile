FROM openjdk:17-jdk-alpine

COPY target/pousada-0.0.1-SNAPSHOT.jar pousada-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/pousada-0.0.1-SNAPSHOT.jar"]
