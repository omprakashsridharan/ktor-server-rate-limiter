plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.omprakash"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.ktorServerCore)
    implementation(libs.ktorServerNetty)
    implementation(project(":lib"))
    implementation(libs.logbackClassic)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}