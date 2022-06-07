project.group = "com.openfaas.kotlin.template"

plugins {
    kotlin("jvm") version "1.3.61"
}

repositories {
    jcenter()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("com.github.s1monw1:openfaas-kotlin-model:1.0.0")
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.5.1")
    testImplementation("org.assertj:assertj-core:3.11.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
