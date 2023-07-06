import com.google.common.truth.Truth.assertWithMessage

object TestUtils {
  fun assertOutput(actual: String, expected: String) {
    val callerMethodName = Throwable().stackTrace[1].methodName
    assertWithMessage(callerMethodName).that(actual).isEqualTo(expected)
  }

  fun assertOutput(actual: String, expected: List<String>) {
    val callerMethodName = Throwable().stackTrace[1].methodName
    assertWithMessage(callerMethodName).that(actual.split(System.lineSeparator())).isEqualTo(expected)
  }
}
