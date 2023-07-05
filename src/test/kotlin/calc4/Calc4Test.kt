import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import java.io.ByteArrayInputStream
import java.io.InputStream

class Calc4Test {
  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Calc4 クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val inputValue = "128"
    val bytes: InputStream = ByteArrayInputStream(inputValue.toByteArray())
    System.setIn(bytes)
    Calc4.main(emptyArray())
    val expected: List<String> = listOf("整数を入力してください", "2倍すると" + inputValue.toInt() * 2)
    assertThat(outputCaptor.getOutput().split(System.lineSeparator())).isEqualTo(expected)
  }
}
