/**
 * Data class for storing test data
 * @param chapter chapter number
 * @param className class name
 * @param methodName method name
 * @param input input data
 * @param expected expected output data
 */
data class TestData(
  val chapter: String,
  val className: String,
  val methodName: String,
  val input: String,
  val expected: String
)
