package utility

/**
 * テストのラベルを生成するためのユーティリティクラスです。
 */
object TestLabelGenerator {
  /**
   * テストデータからテストラベルを生成します。
   *
   * @param simpleTestData テストデータ
   * @return 生成されたテストラベル
   */
  fun generateLabel(simpleTestData: SimpleTestData): String {
    // 入力値が空の場合は、クラス名とメソッド名だけを使用してラベルを生成します。
    return if (simpleTestData.input.all { it.isEmpty() }) {
      generateLabel(simpleTestData.className, simpleTestData.methodName)
    } else {
      // 入力値がある場合は、クラス名、メソッド名、入力値を使用してラベルを生成します。
      generateLabel(simpleTestData.className, simpleTestData.methodName, simpleTestData.input)
    }
  }

  /**
   * クラス名とメソッド名からテストラベルを生成します。
   *
   * @param className クラス名
   * @param methodName メソッド名
   * @return 生成されたテストラベル
   */
  fun generateLabel(className: String, methodName: String): String {
    // 入力値がない場合は、クラス名とメソッド名だけを使用してラベルを生成します。
    return "$className $methodName"
  }

  /**
   * クラス名、メソッド名、入力値からテストラベルを生成します。
   *
   * @param className クラス名
   * @param methodName メソッド名
   * @param input 入力値
   * @return 生成されたテストラベル
   */
  fun generateLabel(className: String, methodName: String, input: String): String {
    // 入力値がある場合は、クラス名、メソッド名、入力値を使用してラベルを生成します。
    return "$className $methodName 入力: $input"
  }

  fun generateLabel(className: String, methodName: String, input: List<String>): String {
    // 入力値がある場合は、クラス名、メソッド名、入力値を使用してラベルを生成します。
    return "$className $methodName 入力: $input"
  }
}
