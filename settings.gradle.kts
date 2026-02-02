pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://repo.spring.io/milestone") }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }
}

rootProject.name = "testcontainers-samples"

include("tc-basics")
include("tc-testng")
include("tc-dockerfile")
include("tc-docker-compose")
include("spring-boot-jpa-demo")
include("spring-boot-redis-demo")
include("spring-boot-couchbase-demo")
include("spring-boot-oracle-demo")
include("spring-boot-mongodb-demo")
include("spring-boot-kafka-demo")
include("spring-boot-rabbitmq-demo")
include("spring-boot-mockserver-demo")
include("spring-boot-wiremock-demo")
include("spring-boot-localstack-demo")
include("spring-boot-microservices")
include("spring-boot-microservices:product-service")
include("spring-boot-microservices:promotion-service")
include("spring-boot-kotlin-demo")
// quarkus-jpa-demo and micronaut-jpa-demo are excluded from the Gradle build
// because their Gradle plugins do not yet support Gradle 9 (required for Java 25).
// Build these modules with Maven: ./mvnw install -pl quarkus-jpa-demo,micronaut-jpa-demo
