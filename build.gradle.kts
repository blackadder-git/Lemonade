plugins {
    kotlin("jvm") version "1.8.20"
    application
    //kotlin("plugin.serialization") version "1.8.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    //implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}