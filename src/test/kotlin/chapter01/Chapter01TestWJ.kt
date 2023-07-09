package chapter01

import PrintStreamExtension
import TestUtils
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

/**
 * テキストの第一章に記載された各クラスのテストを行います。
 *
 * <p>
 * このクラスは、テキストの第一章に記載された各クラスの各メソッドが正しく動作するかをテストします。
 * </p>
 */
@DisplayName("第一章")
class Chapter01TestWJ {
  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  /**
   * {@link Hello}クラスのテストを行います。
   *
   * <p> このクラスは、{@link Hello}クラスの各メソッドが正しく動作するかをテストします。 </p>
   */
  @Nested
  @DisplayName("Helloクラス")
  inner class HelloTest {
    /**
     * {@link Hello#main}メソッドのテストを行います。
     *
     * <p> このメソッドは、{@link Hello}クラスのmainメソッドが正しく動作するかをテストします。 </p>
     */
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testHelloMain() {
      Hello.main(emptyArray())
      val expectedOutput = "Hello!"
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link HelloJava}クラスのテストを行います。
   *
   * <p> このクラスは、{@link HelloJava}クラスの各メソッドが正しく動作するかをテストします。 </p>
   */
  @Nested
  @DisplayName("HelloJavaクラス")
  inner class HelloJavaTest {
    /**
     * {@link HelloJava#main}メソッドのテストを行います。
     *
     * <p> このメソッドは、{@link HelloJava}クラスのmainメソッドが正しく動作するかをテストします。 </p>
     */
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testHelloJavaMain() {
      HelloJava.main(emptyArray())
      val expectedOutput = "Hello Java world!"
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }
}
