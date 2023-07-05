import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

/**
 * {@link HelloJava}クラスのテストを行います。
 *
 * <p>
 * このクラスは、{@link HelloJava}クラスの各メソッドが正しく動作するかをテストします。
 * </p>
 */
class HelloJavaTest {
  @JvmField
  @RegisterExtension
  val outputCaptor = PrintStreamExtension()

  @DisplayName("HelloJava クラスの main メソッドのテスト")
  @Test
  fun testMain() {
    val expectedOutput = "Hello Java world!"
    HelloJava.main(emptyArray())
    assertThat(outputCaptor.getOutput().trim()).isEqualTo(expectedOutput)
  }

}
