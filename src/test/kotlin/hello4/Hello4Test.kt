import com.google.common.truth.Truth.assertThat
import java.io.ByteArrayInputStream
import java.io.InputStream
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class Hello4Test {
  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Hello4 クラスの main メソッドのテスト")
  @Test
  fun testMain() {

    val input = "John"
    val bytes: InputStream = ByteArrayInputStream(input.toByteArray())
    System.setIn(bytes)
    Hello4.main(emptyArray())
    val expected: List<String> = listOf("お名前は?", input + "さん、こんにちは")
    assertThat(outputCaptor.getOutput().split(System.lineSeparator())).isEqualTo(expected)
  }
}
