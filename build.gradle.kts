plugins {
    id("java")
}

group = "com.eszalud"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.1")
    testImplementation("org.mockito:mockito-core:5.20.0")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.0.1")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

tasks.test {
    useJUnitPlatform()
}