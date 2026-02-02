plugins {
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependency.management) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.spotless)
}

allprojects {
    group = "com.sivalabs"
    version = "0.0.1-SNAPSHOT"
}

spotless {
    java {
        target("*/src/**/*.java")
        importOrder()
        removeUnusedImports()
        palantirJavaFormat(libs.versions.palantir.java.format.get())
        formatAnnotations()
    }
    kotlin {
        target("*/src/**/*.kt")
        ktlint()
    }
}
