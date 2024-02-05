FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/pousada-0.0.1-SNAPSHOT.jar /app/pousada-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "pousada-0.0.1-SNAPSHOT.jar"]