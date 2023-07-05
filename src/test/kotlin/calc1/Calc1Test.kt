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

  @DisplayName("Calc2 クラスの main メソッドのテスト")
  @Test
  fun testCalc2Main() {
    val expectedOutput = "10"
    Calc2.main(emptyArray())
    assertThat(outputCaptor.getOutput()).isEqualTo(expectedOutput)
  }

  @DisplayName("Calc3 クラスの main メソッドのテスト")
  @Test
  fun testCalc3Main() {
    val expectedOutput: List<String> = listOf("2 + 7 = 9", "2 - 7 = -5")
    Calc3.main(emptyArray())
    assertThat(outputCaptor.getOutput().split(lineSeparator())).isEqualTo(expectedOutput)
  }

  @DisplayName("Calc4 クラスの main メソッドのテスト")
  @Test
  fun testCalc4Main() {
    val inputValue = "128"
    val bytes: InputStream = ByteArrayInputStream(inputValue.toByteArray())
    System.setIn(bytes)
    Calc4.main(emptyArray())
    val expectedOutput: List<String> = listOf("整数を入力してください", "2倍すると" + inputValue.toInt() * 2)
    assertThat(outputCaptor.getOutput().split(lineSeparator())).isEqualTo(expectedOutput)
  }

  @DisplayName("Calc5 クラスの main メソッドのテスト")
  @Test
  fun testCalc5Main() {
    Calc5.main(emptyArray())
    val expectedOutput: List<String> = listOf((7 / 4.0).toString(), (7 / 3.0).toString())
    assertThat(outputCaptor.getOutput().split(lineSeparator())).isEqualTo(expectedOutput)
  }
}
