# E-Commerce Application

A deliberately simple Java/Maven Spring Boot application for DevOps practice.

## Endpoints

- `GET /products`
- `GET /orders`
- `GET /users`
- `GET /health`

## Prerequisites

- Java 21
- Maven 3.9+

## Run locally

```bash
mvn clean test
mvn spring-boot:run
```

Then test:

```bash
curl http://localhost:8080/products
curl http://localhost:8080/orders
curl http://localhost:8080/users
curl http://localhost:8080/health
```

## Build JAR

```bash
mvn clean package
java -jar target/ecommerce-app-1.0.0.jar
```

The application is intentionally small. The next DevOps phases can add Docker, Jenkins CI, SonarQube, Trivy, ECR, Kubernetes, monitoring, and deployment without changing the core application much.
