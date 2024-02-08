FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

ADD target/pousada-0.0.1-SNAPSHOT.jar pousada.jar

CMD ["java", "-jar", "pousada.jar"]
