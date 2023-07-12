package chapter02

import PrintStreamExtension
import io.kotest.assertions.fail
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * NameDisp1クラスのテストを行うためのクラスです。
 */
class NameDisp1Test : FunSpec({
  context("第二章") {
    val outputCaptor = PrintStreamExtension()
    extension(outputCaptor)

    /*
     * テスト対象のクラス名、メソッド名、期待値を設定する。
     */
    val className = "NameDisp1"
    val methodName = "main"
    val expected = 2

    val testLabel = "$className $methodName"
    test(testLabel) {
      try {
        /*
         * テスト対象のメソッドを実行する。
         */
        val clazz = Class.forName(className)
        val method = clazz.getMethod(methodName, Array<String>::class.java)
        method.invoke(null, emptyArray<String>())
        /*
         * 出力が2行であることを確認する。
         */
        outputCaptor.getOutput().split(System.lineSeparator()).size shouldBe expected
      } catch (e: ClassNotFoundException) {
        /*
         * テスト対象のメソッドが見つからない場合はテストを失敗させる。
         */
        fail("Method not found: $className $methodName")
      }
    }
  }
})

