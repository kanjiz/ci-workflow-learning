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
  val input: List<String> = emptyList(),
  val expected: List<String>,
  val isValid: Boolean = true
) {
  init {
    require(className.isNotBlank()) { "Class name must not be blank" }
    require(methodName.isNotBlank()) { "Method name must not be blank" }
  }

  override fun toString(): String {
    return " Class: $className, Method: $methodName, Input: $input, Expected: $expected"
  }
}
