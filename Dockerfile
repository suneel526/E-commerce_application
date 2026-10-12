# Build stage
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /workspace

# Copy dependency definition first to improve Docker layer caching
COPY pom.xml .

# Download dependencies separately
RUN mvn -B -ntp dependency:go-offline

# Copy application source
COPY src ./src

# Package application without rerunning tests
# Run tests in the Jenkins Maven build stage
RUN mvn -B -ntp clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre

WORKDIR /app

# Create a non-root user
RUN groupadd --system spring \
    && useradd --system --gid spring --home-dir /app spring

# Copy the built application
COPY --from=build /workspace/target/ecommerce-app-1.0.0.jar /app/app.jar

# Run as non-root
USER spring:spring

EXPOSE 8080

ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "/app/app.jar"]
