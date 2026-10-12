
FROM eclipse-temurin:21-jre

WORKDIR /app

# Create a dedicated, unprivileged application user.
RUN groupadd --system appgroup \
    && useradd --system --gid appgroup \
       --home-dir /app --shell /usr/sbin/nologin appuser

COPY --chown=appuser:appgroup target/java-app.jar /app/java-app.jar

USER appuser:appgroup

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/java-app.jar"]
