# ecommerce-app 1.0.0

A small Spring Boot REST API intended for CI/CD and DevOps practice.

## Requirements

- JDK 21
- Maven 3.9+
- Docker (optional)

## Build and test

```bash
mvn -B -ntp clean verify
```

The executable JAR is created at:

```text
target/ecommerce-app-1.0.0.jar
```

## Run locally

```bash
mvn spring-boot:run
```

Or run the packaged JAR:

```bash
java -jar target/ecommerce-app-1.0.0.jar
```

The API listens on port 8080 by default. Override it with `SERVER_PORT`, for example:

```bash
SERVER_PORT=8081 java -jar target/ecommerce-app-1.0.0.jar
```

## Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/health` | Basic health response |
| GET | `/api/products` | List sample products |
| GET | `/api/products/1` | Retrieve a product by ID |
| GET | `/api/products/999` | Returns HTTP 404 for an unknown product |

Example:

```bash
curl http://localhost:8080/api/health
curl http://localhost:8080/api/products
curl http://localhost:8080/api/products/1
```

Product data is in-memory sample data; this project does not use a database or implement checkout/payment.

## Docker

Build the image:

```bash
docker build -t ecommerce-app:1.0.0 .
```

Run it:

```bash
docker run --rm -p 8080:8080 ecommerce-app:1.0.0
```

The runtime container runs as a non-root `spring` user.

## Spring Boot 4 testing note

Spring Boot 4 places MVC testing support in a separate module. This project includes
`spring-boot-starter-webmvc-test` and imports `AutoConfigureMockMvc` from:

```java
org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
```

## Jenkins pipeline integration

The Maven package name is deliberately `ecommerce-app-1.0.0.jar`, matching this project's
`pom.xml`. If your Jenkinsfile copies a JAR to another name (for example `target/java-app.jar`),
ensure that copy command uses this exact source path.
