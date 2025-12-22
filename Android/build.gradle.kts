import org.gradle.jvm.toolchain.JavaLanguageVersion

plugins {
  kotlin("jvm") version "1.9.0"
  id("java")
  id("io.qameta.allure") version "2.9.6"
}

group = "com.autotests"
version = "1.0.0"

repositories {
  mavenCentral()
}

val allureVersion = "2.24.0"
val junitVersion = "5.10.0"
val slf4jVersion = "2.0.6"
val jacksonVersion = "2.16.1"
val selenideVersion = "7.0.4"
val seleniumVersion = "4.16.1"
val appiumJavaVersion = "9.0.0"

dependencies {
  implementation(kotlin("stdlib"))
  implementation("io.appium:java-client:$appiumJavaVersion") {
    exclude(group = "org.seleniumhq.selenium", module = "selenium-java")
  }
  testImplementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")
  testImplementation("com.codeborne:selenide:$selenideVersion")
  testImplementation("com.codeborne:selenide-appium:$selenideVersion")
  testImplementation("io.qameta.allure:allure-selenide:$allureVersion")
  testImplementation("io.qameta.allure:allure-junit5:$allureVersion")
  testImplementation("org.assertj:assertj-core:3.24.2")
  implementation("org.slf4j:slf4j-simple:$slf4jVersion")
  implementation("com.typesafe:config:1.4.2")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
  implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
  implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
  implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
}

tasks.test {
  useJUnitPlatform()
  testLogging {
    events("passed", "skipped", "failed")
    showStandardStreams = true
  }
}

kotlin {
  jvmToolchain(17)
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
  }
}