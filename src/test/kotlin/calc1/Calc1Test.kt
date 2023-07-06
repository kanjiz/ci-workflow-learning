import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.lang.System.lineSeparator

class Calc1Test {

  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Calc1 クラスの main メソッドのテスト")
  @Test
  fun testCalc1Main() {
    val expectedOutput: List<String> = listOf("4", "1", "3")
    Calc1.main(emptyArray())
    assertThat(outputCaptor.getOutput().split(lineSeparator())).isEqualTo(expectedOutput)
  }

  @DisplayName("Calc5 クラスの main メソッドのテスト")
  @Test
  fun testCalc5Main() {
    Calc5.main(emptyArray())
    val expectedOutput: List<String> = listOf(
      (7 / 4.0).toString(),
      (7 / 3.0).toString())
    assertThat(outputCaptor.getOutput().split(lineSeparator())).isEqualTo(expectedOutput)
  }
}
