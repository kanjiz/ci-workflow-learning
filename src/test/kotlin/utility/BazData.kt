package utility

data class BazData(
  val className: String,
  val methods: List<MethodData>
) {
  init {
    require(className.isNotEmpty()) { "クラス名が空です。" }
  }
}
