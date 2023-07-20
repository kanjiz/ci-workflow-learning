package utility

import kotlinx.serialization.Serializable

@Serializable
data class MethodData(
  val methodName: String,
  val returnType: String,
  val parameters: List<ParameterData>,
  val expected: List<String>
) {
  init {
    require(methodName.isNotBlank()) { "Method name is blank." }
    require(returnType.isNotBlank()) { "Return type is blank." }
    require(
      returnType in listOf(
        "void",
        "String",
        "String[]",
        "Int",
        "Double",
        "Boolean"
      )
    ) { "Return type is invalid." }
  }

  override fun toString(): String {
    return "$methodName: $returnType, parameters: $parameters, expected: $expected"
  }
}
