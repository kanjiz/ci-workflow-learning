import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

/**
 * テキストの第一章に記載された各クラスのテストを行います。
 *
 * <p>
 * このクラスは、テキストの第一章に記載された各クラスの各メソッドが正しく動作するかをテストします。
 * </p>
 */
@DisplayName("第一章のテスト")
class Chapter01Test {
  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()
  /**
   * {@link Hello}クラスのテストを行います。
   *
   * <p>
   * このメソッドは、{@link Hello}クラスのmainメソッドが正しく動作するかをテストします。
   * </p>
   */
  @DisplayName("Hello クラスの main メソッドのテスト")
  @Test
  fun testHelloMain() {
    val expectedOutput = "Hello!"
    Hello.main(emptyArray())
    assertThat(outputCaptor.getOutput()).isEqualTo(expectedOutput)
  }

  /**
   * {@link HelloJava}クラスのテストを行います。
   *
   * <p>
   * このメソッドは、{@link HelloJava}クラスのmainメソッドが正しく動作するかをテストします。
   * </p>
   */
  @DisplayName("HelloJava クラスの main メソッドのテスト")
  @Test
  fun testHelloJavaMain() {
    val expectedOutput = "Hello Java world!"
    HelloJava.main(emptyArray())
    assertThat(outputCaptor.getOutput()).isEqualTo(expectedOutput)
  }
}
