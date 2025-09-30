plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.8.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.15.0")
    testImplementation("io.qameta.allure:allure-testng:2.22.0")
}

tasks.test {
    useTestNG()
    systemProperty("allure.results.directory", "$buildDir/allure-results")
}
