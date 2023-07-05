import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class Hello3Test {
  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Hello3 クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val expected: List<String> = listOf("こんにちは", "元気ですか？")
    Hello3.main(emptyArray())
    assertThat(outputCaptor.getOutput().split(System.lineSeparator())).isEqualTo(expected)
  }
}
