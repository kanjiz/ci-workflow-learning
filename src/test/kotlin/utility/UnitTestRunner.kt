package utility

import io.kotest.assertions.fail
import io.kotest.core.spec.style.FunSpec
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.Charset

/**
 * ユニットテストを実行するためのクラスです。
 * Kotestフレームワークを使用してテストを実行し、出力の検証を行います。
 */
class UnitTestRunner : FunSpec() {

  /**
   * テストデータを受け取り、テストを実行して出力を検証します。
   *
   * @param testData テストデータ
   */
  fun runTest(testData: TestData) {
    val nativeEncoding: Charset = Charset.forName(System.getProperty("native.encoding"))
    try {
      // テスト対象のクラスとメソッドを取得する
      val clazz = Class.forName(testData.className)
      val method = clazz.getMethod(testData.methodName, Array<String>::class.java)

      val inputList = testData.input.split(",")
      inputList.forEach {
        val bytes: InputStream =
          ByteArrayInputStream(it.toByteArray(nativeEncoding))
        System.setIn(bytes)
      }
      // テスト対象のメソッドを実行する
      method.invoke(null, emptyArray<String>())
    } catch (e: ClassNotFoundException) {
      // クラスが見つからない場合は、エラーメッセージを表示する
      fail("Class not found: ${testData.className} ${testData.methodName}")
    } catch (e: NoSuchMethodException) {
      // メソッドが見つからない場合は、エラーメッセージを表示する
      fail("Method not found: ${testData.className} ${testData.methodName}")
    }

    // 出力を検証する
    TestUtils.assertOutput(PrintStreamExtension.getOutput(), testData.expected)
  }
}
