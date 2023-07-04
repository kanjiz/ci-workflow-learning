import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.System.lineSeparator

class Calc1Test {
  @DisplayName("Calc1 クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val expectedOutput = arrayOf("4", "1", "3")
    val actualOutput = captureOutput { Calc1.main(arrayOf()) }
    assertThat(actualOutput.trim().split(lineSeparator()).toTypedArray()).isEqualTo(expectedOutput)
  }

  private fun captureOutput(block: () -> Unit): String {
    val out = System.out
    val bytes = ByteArrayOutputStream()
    System.setOut(PrintStream(bytes))
    try {
      block()
    } finally {
      System.setOut(out)
    }
    return bytes.toString()
  }
}
