package utility

import kotlinx.serialization.Serializable

@Serializable
data class MethodData(
  val methodName: String,
  val returnType: String,
  val parameters: List<ParameterData>,
  val expected: List<String>
)
