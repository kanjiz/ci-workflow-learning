import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

/**
 * {@link Hello}クラスのテストを行います。
 *
 * <p> このクラスは、{@link Hello}クラスの各メソッドが正しく動作するかをテストします。 </p>
 */
class HelloTest {
  @JvmField
  @RegisterExtension
  val outputCaptor = PrintStreamExtension()

  @DisplayName("Hello クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val expectedOutput = "Hello!"
    Hello.main(emptyArray())
    assertThat(outputCaptor.getOutput().trim()).isEqualTo(expectedOutput)
  }
}
