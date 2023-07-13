import net.ltgt.gradle.errorprone.errorprone
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  java
  checkstyle
  // Google Error Proneを使用するためのプラグイン
  id("net.ltgt.errorprone") version "3.1.0"
  // Java20に対応させるため、1.8ではなく1.9を指定
  kotlin("jvm") version "1.9.0"
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(19))
  }
}

checkstyle {
  toolVersion = "10.12.1"
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("com.google.guava:guava:32.1.1-jre")
  testImplementation("org.json:json:20230618")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
  testImplementation("io.kotest:kotest-runner-junit5:5.6.2")
  testImplementation("io.kotest:kotest-assertions-core:5.6.2")
  testImplementation("io.kotest:kotest-property:5.6.2")
  testImplementation("com.google.truth:truth:1.1.5")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
  errorprone("com.google.errorprone:error_prone_core:2.20.0")
}

tasks.withType<Checkstyle>().configureEach {
  reports {
    xml.required.set(true)
    html.required.set(false)
  }
}

tasks.withType<JavaCompile>().configureEach {
  options.encoding = "UTF-8"
  options.errorprone {}
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
  testLogging {
    events("passed", "skipped", "failed")

    options {
      showCauses = false
      showExceptions = false
      showStackTraces = false
      showStandardStreams = false
    }
  }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "19"
}
