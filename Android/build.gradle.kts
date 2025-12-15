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
val ownerVersion = "1.0.12"
val appiumJavaVersion = "9.0.0"

dependencies {
  implementation(kotlin("stdlib"))

  // Appium с исключением Selenium чтобы избежать конфликтов версий
  implementation("io.appium:java-client:$appiumJavaVersion") {
    exclude(group = "org.seleniumhq.selenium", module = "selenium-java")
  }

  // Selenium отдельно
  testImplementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")

  // Selenide
  testImplementation("com.codeborne:selenide:$selenideVersion")
  testImplementation("com.codeborne:selenide-appium:$selenideVersion")

  // Owner
  testImplementation("org.aeonbits.owner:owner:$ownerVersion")

  // Allure - ДОБАВЬ testImplementation!
  testImplementation("io.qameta.allure:allure-selenide:$allureVersion")
  testImplementation("io.qameta.allure:allure-junit5:$allureVersion")

  // AssertJ
  testImplementation("org.assertj:assertj-core:3.24.2")

  // Logging - исправь дублирование
  implementation("org.slf4j:slf4j-simple:$slf4jVersion")

  // Config
  implementation("com.typesafe:config:1.4.2")

  // JUnit 5 - ВЕРСИЯ 5.10.0
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")

  // Jackson
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
    showStandardStreams = true  // Показывать логи в консоли
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