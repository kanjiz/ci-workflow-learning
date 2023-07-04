import net.ltgt.gradle.errorprone.errorprone
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  java
  checkstyle
  // Google Error Proneを使用するためのプラグイン
  id("net.ltgt.errorprone") version "3.1.0"
  // Java20に対応させるため、1.8ではなく1.9を指定
  kotlin("jvm") version "1.9.0-RC"
}

checkstyle {
  toolVersion = "10.12.1"
}

repositories {
  mavenCentral()
}

dependencies {
  errorprone("com.google.errorprone:error_prone_core:2.20.0")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
  testImplementation("com.google.truth:truth:1.1.5")
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

// `test`タスクの設定
tasks.test {
  // JUnit 5を使用するように設定
  useJUnitPlatform()
  testLogging {
    // ログに表示するイベントを指定
    events("passed", "skipped", "failed")
  }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
//  jvmTarget = "1.8"
//  jvmTarget = "20"
}
