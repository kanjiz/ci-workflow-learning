import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import java.lang.System.lineSeparator

class Calc1Test {
  @JvmField
  @RegisterExtension
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Calc1 クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val expectedOutput: List<String> = listOf("4", "1", "3")
    Calc1.main(emptyArray())
    assertThat(outputCaptor.getOutput().trim().split(lineSeparator())).isEqualTo(expectedOutput)
  }
}
