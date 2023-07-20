package utility

import kotlinx.serialization.Serializable

/**
 * Data class for storing test data
 * @param className class name
 * @param methodName method name
 * @param input input data
 * @param expected expected output data
 * @param isValid whether the test data is valid
 */
@Serializable
data class SimpleTestData(
  val className: String,
  val methodName: String,
  val input: List<String>,
  val expected: List<String>,
  val isValid: Boolean = true
) {
  init {
    require(className.isNotBlank()) { "Class name must not be blank" }
    require(methodName.isNotBlank()) { "Method name must not be blank" }
  }

  class Builder {
    private var className: String = ""
    private var methodName: String = ""
    private var input: List<String> = listOf()
    private var expected: List<String> = listOf()
    private var isValid: Boolean = true

    fun className(className: String) = apply { this.className = className }
    fun methodName(methodName: String) = apply { this.methodName = methodName }
    fun input(input: List<String>) = apply { this.input = input }
    fun expected(expected: List<String>) = apply { this.expected = expected }
    fun isValid(isValid: Boolean) = apply { this.isValid = isValid }
    fun build() = SimpleTestData(className, methodName, input, expected, isValid)
  }

  companion object {
    fun builder() = Builder()
  }

  override fun toString(): String {
    return " Class: $className, Method: $methodName, Input: $input, Expected: $expected"
  }
}
