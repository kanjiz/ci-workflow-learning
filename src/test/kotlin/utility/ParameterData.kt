package utility

/**
 * パラメータの名前と型を表すデータクラス。
 *
 * @property name パラメータの名前
 * @property type パラメータの型
 */
data class ParameterData(val name: String, val type: String) {
  init {
    require(name.isBlank()) { "Parameter name is blank." }
    require(type.isBlank()) { "Parameter type is blank." }
  }

  override fun toString(): String {
    return "$name: $type"
  }
}
