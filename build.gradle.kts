plugins {
  java
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.0")
  testImplementation("com.google.truth:truth:1.1.5")
}

tasks.withType<JavaCompile>().configureEach {
  options.encoding = "UTF-8"
}

// `test`タスクの設定
tasks.test {
  // JUnit 5を使用するように設定
  useJUnitPlatform()
  testLogging {
    // ログに表示するイベントを指定
    events("passed", "skipped", "failed")
    outputs.upToDateWhen { false }
    showCauses = true
    // 標準出力・標準エラー出力を表示
    showStandardStreams = true
  }
}
