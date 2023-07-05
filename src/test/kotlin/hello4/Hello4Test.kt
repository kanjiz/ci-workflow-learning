import com.google.common.truth.Truth.assertThat
import java.io.ByteArrayInputStream
import java.io.InputStream
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import java.nio.charset.Charset

class Hello4Test {
  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Hello4 クラスの main メソッドのテスト")
  @Test
  fun testMain() {

    val japaneseName = "田中一郎"
    val bytes: InputStream = ByteArrayInputStream(japaneseName.toByteArray(Charset.forName(System.getProperty("native.encoding"))))
    System.setIn(bytes)
    Hello4.main(emptyArray())
    val expected: List<String> = listOf("お名前は?", japaneseName + "さん、こんにちは")
    assertThat(outputCaptor.getOutput().split(System.lineSeparator())).isEqualTo(expected)
  }
}
