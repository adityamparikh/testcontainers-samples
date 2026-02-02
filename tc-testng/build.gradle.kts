plugins {
    java
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    implementation(platform(libs.testcontainers.bom))

    implementation(libs.postgresql)
    implementation(libs.logback.classic)

    testImplementation(libs.testng)
    testImplementation(libs.testcontainers.postgresql)
}

tasks.withType<Test> {
    useTestNG()
}
