plugins {
    java
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.restclient)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.h2)
    implementation(libs.resilience4j.spring.boot3)

    developmentOnly(libs.spring.boot.devtools)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.spring.boot.starter.webmvc.test)
    testImplementation(libs.wiremock.standalone)
    testImplementation(libs.testcontainers.junit.jupiter)
    testImplementation(libs.testcontainers.toxiproxy)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
