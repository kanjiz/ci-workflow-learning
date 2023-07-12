object TestLabelGenerator {
  /**
   * テストのラベルを生成します。
   *
   * @param testData テストデータ
   * @return テストのラベル
   *
   */
  fun generateLabel(testData: TestData): String {
    return if (testData.input.isEmpty()) {
      "${testData.className} ${testData.methodName}"
    } else {
      "${testData.className} ${testData.methodName} 入力: ${testData.input}"
    }
  }
}
