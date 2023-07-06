package chapter02

import PrintStreamExtension
import TestUtils
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.Charset

/**
 * テキストの第二章に記載された各クラスのテストを行います。
 *
 * <p>
 * このクラスは、テキストの第二章に記載された各クラスの各メソッドが正しく動作するかをテストします。
 * </p>
 */
@DisplayName("第二章")
class Chapter02Test {
  @RegisterExtension
  @JvmField
  val outputCaptor = PrintStreamExtension()

  /**
   * {@link Calc1}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Calc1}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Calc1クラス")
  inner class Calc1Test {

    /**
     * {@link Calc1#main}メソッドのテストを行います。
     *
     * <p>
     * このメソッドは、{@link Calc1}クラスのmainメソッドが正しく動作するかをテストします。
     * </p>
     */
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testCalc1Main() {
      val expectedOutput: List<String> = listOf("4", "1", "3")
      Calc1.main(emptyArray())
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link Calc2}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Calc2}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Calc2クラス")
  inner class Calc2Test {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testCalc2Main() {
      val expectedOutput = "10"
      Calc2.main(emptyArray())
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link Calc3}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Calc3}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Calc3クラス")
  inner class Calc3Test {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testCalc3Main() {
      val expectedOutput: List<String> = listOf("2 + 7 = 9", "2 - 7 = -5")
      Calc3.main(emptyArray())
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link Hello4}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Hello4}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Hello4クラス")
  inner class Hello4Test {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testHello4Main() {

      val japaneseName = "田中一郎"
      val bytes: InputStream = ByteArrayInputStream(japaneseName.toByteArray(Charset.forName(System.getProperty("native.encoding"))))
      System.setIn(bytes)
      Hello4.main(emptyArray())
      val expectedOutput: List<String> = listOf("お名前は?", japaneseName + "さん、こんにちは")
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }
}
