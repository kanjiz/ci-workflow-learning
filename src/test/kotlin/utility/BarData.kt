package utility

import kotlinx.serialization.Serializable

@Serializable
data class BarData(
  val methodName: String,
  val returnType: String = "void",
  val parameters: List<ParameterData>,
  val expected: List<String>
) {
  init {
    require(methodName.isNotEmpty()) { "メソッド名が空です。" }
    require(returnType.isNotEmpty()) { "戻り値の型が空です。" }
  }
}
