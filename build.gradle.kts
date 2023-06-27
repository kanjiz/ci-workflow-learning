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

tasks.test {
  useJUnitPlatform()
  testLogging {
    events("passed", "skipped", "failed")
    outputs.upToDateWhen { false }
    showCauses = true
    showStandardStreams = true
  }
}
