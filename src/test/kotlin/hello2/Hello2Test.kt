import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class Hello2Test {
  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Hello2 クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val expectedOutput = listOf("Hello!", "How you doing?")
    Hello2.main(emptyArray())
     assertThat(outputCaptor.getOutput().split(System.lineSeparator())).isEqualTo(expectedOutput)
  }
}
