package utility

/**
 * テストのラベルを生成するためのユーティリティクラスです。
 */
object TestLabelGenerator {
  /**
   * テストデータからテストラベルを生成します。
   *
   * @param testData テストデータ
   * @return 生成されたテストラベル
   */
  fun generateLabel(testData: TestData): String {
    // 入力値が空の場合は、クラス名とメソッド名だけを使用してラベルを生成します。
    return if (testData.input.isEmpty()) {
      generateLabel(testData.className, testData.methodName)
    } else {
      // 入力値がある場合は、クラス名、メソッド名、入力値を使用してラベルを生成します。
      generateLabel(testData.className, testData.methodName, testData.input)
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
}
