package utility

import io.kotest.core.listeners.AfterEachListener
import io.kotest.core.listeners.BeforeEachListener
import io.kotest.core.spec.AutoScan
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**
 * System.outの出力をキャプチャするための拡張クラスです。
 *
 * このクラスは、Kotestの `BeforeEachListener` と `AfterEachListener` インターフェースを実装しています。
 * これにより、テストメソッドの実行前にSystem.outの出力をキャプチャし、テストメソッドの実行後にSystem.outの出力を元に戻すことができます。
 *
 * また、このクラスは、キャプチャされた出力を取得するための `getOutput()` メソッドを提供しています。
 *
 */
@AutoScan
object PrintStreamExtension : BeforeEachListener, AfterEachListener {

  /**
   * System.outの初期値を保持する変数です。
   */
  private val out = System.out

  /**
   * System.outの出力をキャプチャするためのByteArrayOutputStreamです。
   */
  private val bytes = ByteArrayOutputStream()

  /**
   * ByteArrayOutputStreamにキャプチャされた出力を取得するためのメソッドです。
   *
   * @return ByteArrayOutputStreamにキャプチャされた出力
   */
  fun getOutput(): String {
    return bytes.toString().trim()
  }

  /**
   * テストメソッドの実行前にSystem.outの出力をキャプチャするためのメソッドです。
   *
   * @param testCase テストケース
   */
  override suspend fun beforeEach(testCase: TestCase) {
    super.beforeEach(testCase)
    System.setOut(PrintStream(bytes))
  }

  /**
   * テストメソッドの実行後にSystem.outの出力を元に戻すためのメソッドです。
   * @param testCase テストケース
   * @param result テスト結果
   */
  override suspend fun afterEach(testCase: TestCase, result: TestResult) {
    super.afterEach(testCase, result)
    System.setOut(out)
    bytes.reset()
  }
}
