import net.ltgt.gradle.errorprone.errorprone

plugins {
  java
  checkstyle
  // Google Error Proneを使用するためのプラグイン
  id("net.ltgt.errorprone") version "3.1.0"
}

checkstyle {
  toolVersion = "10.12.1"
}

repositories {
  mavenCentral()
}

dependencies {
  errorprone("com.google.errorprone:error_prone_core:2.20.0")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.0")
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
  options.errorprone {
  }
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
