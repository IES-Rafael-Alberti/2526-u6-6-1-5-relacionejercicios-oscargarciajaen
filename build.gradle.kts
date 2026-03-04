plugins {
    kotlin("jvm") version "1.9.24"
    application
    id("org.jetbrains.dokka") version "1.9.20"
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}

tasks.dokkaHtml {
    outputDirectory.set(file("Doc"))
}

tasks.dokkaHtml {
    dokkaSourceSets.configureEach {
        sourceRoots.from(file("src/main/kotlin/es.ies.ejercicios.u6/ej64/ProgramaDocumentable"))
    }
}
