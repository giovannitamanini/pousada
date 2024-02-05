FROM eclipse-temurin:17

WORKDIR /app

COPY target/pousada-0.0.1-SNAPSHOT.jar /app/pousada-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "pousada-0.0.1-SNAPSHOT.jar"]