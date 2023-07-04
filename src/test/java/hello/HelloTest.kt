import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**
 * {@link Hello}クラスのテストを行います。
 *
 * <p>
 * このクラスは、{@link Hello}クラスの各メソッドが正しく動作するかをテストします。
 * </p>
 */
class HelloTest {
  @DisplayName("Hello クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val expectedOutput = "Hello!"
    val actualOutput = captureOutput { Hello.main(arrayOf()) }
    assertThat(actualOutput.trim()).isEqualTo(expectedOutput)
  }

  private fun captureOutput(block: () -> Unit): String {
    val bytes = ByteArrayOutputStream()
    val out = PrintStream(bytes)
    System.setOut(out)
    try {
      block()
    } finally {
      System.setOut(System.out)
      out.close()
    }
    return bytes.toString()
  }
}
