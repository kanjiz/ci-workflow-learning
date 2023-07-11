package chapter01

import MethodExecutor
import PrintStreamExtension
import TestDataManager
import TestUtils
import io.kotest.assertions.fail
import io.kotest.core.spec.style.FunSpec

/**
 * 第1章のテストを行うためのクラスです。
 */
class Chapter01Test : FunSpec({
  context("第一章") {
    /**
     * 出力をキャプチャするためのPrintStreamExtensionオブジェクトを作成します。
     */
    val outputCaptor = PrintStreamExtension()
    extension(outputCaptor)

    val fileName = "chapter01.json"
    val testDataList = TestDataManager(fileName).getTestDataList()
    /**
     * テストデータリストの各要素に対して、テストを実行します。
     */
    testDataList.forEach {
      test("${it.className} ${it.methodName}") {
        /**
         * テスト対象のメソッドを実行します。
         */
        val didMethodExecute = MethodExecutor.executeMethod(it.className, it.methodName)
        /**
         * メソッドが実行されなかった場合、テストを失敗させます。
         */
        if (!didMethodExecute) {
          fail("Method not found: ${it.className} ${it.methodName}")
        }
        /**
         * 出力が期待値と一致するかどうかを検証します。
         */
        TestUtils.assertOutput(outputCaptor.getOutput(), it.expected)
      }
    }
  }
})
