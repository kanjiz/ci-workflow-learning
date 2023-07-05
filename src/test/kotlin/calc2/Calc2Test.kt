import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class Calc2Test {

  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Calc2 クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val expectedOutput = "10"
    Calc2.main(emptyArray())
    assertThat(outputCaptor.getOutput()).isEqualTo(expectedOutput)
  }
}
