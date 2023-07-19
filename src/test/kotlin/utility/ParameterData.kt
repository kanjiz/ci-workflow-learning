package utility

/**
 * パラメータの名前と型を表すデータクラス。
 *
 * @property name パラメータの名前
 * @property type パラメータの型
 */
data class ParameterData(val name: String, val type: String) {
  init {
    require(name.isNotBlank()) { "Parameter name is blank." }
    require(type.isNotBlank()) { "Parameter type is blank." }
    require(type in listOf("String", "Int", "Double", "Boolean")) { "Parameter type is invalid." }
  }

  override fun toString(): String {
    return "$name: $type"
  }

  class Builder {
    private var name: String = ""
    private var type: String = ""

    fun name(name: String) = apply { this.name = name }
    fun type(type: String) = apply { this.type = type }
    fun build() = ParameterData(name, type)
  }

  companion object {
    fun builder() = Builder()
  }
}
