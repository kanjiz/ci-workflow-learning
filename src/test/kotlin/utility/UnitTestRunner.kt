package utility

import io.kotest.assertions.fail
import io.kotest.core.spec.style.FunSpec
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.Charset
import kotlin.reflect.full.functions

/**
 * ユニットテストを実行するためのクラスです。
 * Kotestフレームワークを使用してテストを実行し、出力の検証を行います。
 */
class UnitTestRunner : FunSpec() {

  /**
   * テストデータを受け取り、テストを実行して出力を検証します。
   *
   * @param simpleTestData テストデータ
   */
  fun runTest(simpleTestData: SimpleTestData) {
    val nativeEncoding: Charset = Charset.forName(System.getProperty("native.encoding"))
    try {
      // テスト対象のクラスとメソッドを取得する
      val clazz = Class.forName(simpleTestData.className)
      val method = clazz.getMethod(simpleTestData.methodName, Array<String>::class.java)

      val inputList = simpleTestData.input
      inputList.forEach {
        val bytes: InputStream =
          ByteArrayInputStream(it.toByteArray(nativeEncoding))
        System.setIn(bytes)
      }
      // テスト対象のメソッドを実行する
      method.invoke(null, emptyArray<String>())
    } catch (e: ClassNotFoundException) {
      // クラスが見つからない場合は、エラーメッセージを表示する
      fail("Class not found: ${simpleTestData.className} ${simpleTestData.methodName}")
    } catch (e: NoSuchMethodException) {
      // メソッドが見つからない場合は、エラーメッセージを表示する
      fail("Method not found: ${simpleTestData.className} ${simpleTestData.methodName}")
    }

    // 出力を検証する
    TestUtils.assertOutput(PrintStreamExtension.getOutput(), simpleTestData.expected)
  }

  fun runTest(className: String, methodData: MethodData) {
    val nativeEncoding: Charset = Charset.forName(System.getProperty("native.encoding"))
    try {
      // テスト対象のクラスとメソッドを取得する
      val clazz = Class.forName(className).kotlin
      val method = clazz.functions.first { it.name == methodData.methodName }

      val inputLines = methodData.input
      val inputText = inputLines.joinToString(System.lineSeparator()) { it }
      val inputStream: InputStream =
        ByteArrayInputStream(inputText.toByteArray(nativeEncoding))
      System.setIn(inputStream)
//      inputList.forEach {
//        val bytes: InputStream =
//          ByteArrayInputStream(it.toByteArray(nativeEncoding))
//        System.setIn(bytes)
//      }
      // テスト対象のメソッドを実行する
      method.call(emptyArray<String>())
    } catch (e: ClassNotFoundException) {
      // クラスが見つからない場合は、エラーメッセージを表示する
      fail("Class not found: $className ${methodData.methodName}")
    } catch (e: NoSuchMethodException) {
      // メソッドが見つからない場合は、エラーメッセージを表示する
      fail("Method not found: $className ${methodData.methodName}")
    }

    // 出力を検証する
    TestUtils.assertOutput(PrintStreamExtension.getOutput(), methodData.expected)
  }
}
