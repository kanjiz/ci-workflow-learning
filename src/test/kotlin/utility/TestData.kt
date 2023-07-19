package utility

/**
 * Data class for storing test data
 * @param className class name
 * @param methodName method name
 * @param input input data
 * @param expected expected output data
 * @param isValid whether the test data is valid
 */
data class TestData(
  val className: String,
  val methodName: String,
  val input: List<String>,
  val expected: List<String>,
  val isValid: Boolean = true
) {

  override fun toString(): String {
    return " Class: $className, Method: $methodName, Input: $input, Expected: $expected"
  }
}
