FROM eclipse-temurin:17

ENV DATABASE_URL jdbc:mysql://localhost:3306/pousada
ENV DATABASE_USERNAME root
ENV DATABASE_PASSWORD 12345
ENV DATABASE_PLATFORM org.hibernate.dialect.MySQL57Dialect
ENV DATABASE_DRIVER com.mysql.cj.jdbc.Driver

COPY target/pousada-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]