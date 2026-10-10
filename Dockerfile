FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/java-app.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
