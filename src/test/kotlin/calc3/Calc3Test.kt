import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class Calc3Test {

  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Calc3 クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val expectedOutput: List<String> = listOf("2 + 7 = 9", "2 - 7 = -5")
    Calc3.main(emptyArray())
    assertThat(outputCaptor.getOutput().split(System.lineSeparator())).isEqualTo(expectedOutput)
  }
}
