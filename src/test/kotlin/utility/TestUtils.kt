package utility

import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe

object TestUtils {

  fun assertOutput(actual: String, expected: List<String>) {
    val callerMethodName = Throwable().stackTrace[1].methodName
    withClue(callerMethodName) { actual.split(System.lineSeparator()) shouldBe expected }
  }
}
