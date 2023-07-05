import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**
 * JUnit 5の拡張機能を使用して、System.outの出力をキャプチャするためのユーティリティクラスです。
 *
 * このクラスを使用すると、テストメソッドの実行前にSystem.outの出力をキャプチャし、 テストメソッドの実行後にSystem.outの出力を元に戻します。
 *
 * また、キャプチャされた出力を取得するためのメソッドも提供しています。
 *
 * @see org.junit.jupiter.api.extension.Extension
 * @see org.junit.jupiter.api.extension.BeforeEachCallback
 * @see org.junit.jupiter.api.extension.AfterEachCallback
 * @see java.io.ByteArrayOutputStream
 * @see java.io.PrintStream
 */
class PrintStreamExtension : BeforeEachCallback, AfterEachCallback {
  /** System.outの初期値を保持する変数です。 */
  private val out = System.out

  /** System.outの出力をキャプチャするためのByteArrayOutputStreamです。 */
  private val bytes = ByteArrayOutputStream()

  /**
   * テストメソッドの前に実行されるメソッドです。 System.outを一時的にByteArrayOutputStreamにリダイレクトします。
   * @param context テストメソッドのコンテキスト
   */
  override fun beforeEach(context: ExtensionContext) {
    System.setOut(PrintStream(bytes))
  }

  /**
   * テストメソッドの後に実行されるメソッドです。 System.outを元の出力に戻し、ByteArrayOutputStreamをリセットします。
   * @param context テストメソッドのコンテキスト
   */
  override fun afterEach(context: ExtensionContext) {
    System.setOut(out)
    bytes.reset()
  }

  /**
   * ByteArrayOutputStreamにキャプチャされた出力を取得するためのメソッドです。
   * @return ByteArrayOutputStreamにキャプチャされた出力
   */
  fun getOutput(): String {
    return bytes.toString()
  }
}
