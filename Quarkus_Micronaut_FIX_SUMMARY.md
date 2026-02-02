### Summary of Changes to Fix Failing Builds (Quarkus & Micronaut)

#### Issue Description
Modules `quarkus-jpa-demo` and `micronaut-jpa-demo` were failing to connect to Docker Desktop on macOS. The error encountered was a `BadRequestException (Status 400)` during Testcontainers' attempt to negotiate the API version with the Docker daemon.

#### Root Cause
The incompatibility between Testcontainers version `1.21.3` and the newer Docker daemon version (`29.1.5`, API `1.52`) caused the connectivity failure.

---

#### 1. Changes in `quarkus-jpa-demo`

*   **Upgraded Testcontainers**: Updated `testcontainers.version` from `1.21.3` to `2.0.3` in `pom.xml`.
*   **Dependency Management**: Added `testcontainers-bom` to the `dependencyManagement` section to ensure all transitive Testcontainers dependencies are aligned to version `2.0.3`.
*   **Artifact Renaming**: Updated the PostgreSQL Testcontainers artifact ID from `postgresql` to `testcontainers-postgresql` to match the naming convention in version `2.0.3`.
*   **Explicit Test Resource**: Re-enabled `@QuarkusTestResource(PostgresResource.class)` in `TodoControllerTest.java` and ensured `PostgresResource.java` correctly manages the container lifecycle and provides JDBC properties to the test environment.
*   **Dev Services Configuration**: Explicitly disabled Quarkus Dev Services (`quarkus.datasource.devservices.enabled=false`) to favor the manually managed Testcontainer via `PostgresResource`.

#### 2. Changes in `micronaut-jpa-demo`

*   **Upgraded Testcontainers**: Updated `testcontainers.version` to `2.0.3` in `pom.xml`.
*   **Dependency Management**: Added `testcontainers-bom` to the `dependencyManagement` section.
*   **JDBC Driver Switch**: Switched from Micronaut Test Resources to using the direct Testcontainers JDBC driver for tests.
    *   Updated the test datasource URL to: `jdbc:tc:postgresql:17-alpine:///postgres`.
    *   Added `testcontainers-jdbc` dependency to `pom.xml`.
*   **Annotation Processor Alignment**: Ensured Micronaut and Testcontainers dependencies are compatible within the Maven build lifecycle.

---

#### Verification
The builds were verified by running the following commands, confirming that the tests now pass successfully:

```bash
# Quarkus
mvn clean test -pl quarkus-jpa-demo -Dtest=TodoControllerTest

# Micronaut
mvn clean test -pl micronaut-jpa-demo -Dtest=TodoControllerTest
```
