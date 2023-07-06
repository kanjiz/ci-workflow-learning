package chapter02

import PrintStreamExtension
import TestUtils
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.junit.jupiter.api.BeforeEach
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
      Calc1.main(emptyArray())
      val expectedOutput: List<String> = listOf("4", "1", "3")
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
      Calc2.main(emptyArray())
      val expectedOutput = "10"
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
      Calc3.main(emptyArray())
      val expectedOutput: List<String> = listOf("2 + 7 = 9", "2 - 7 = -5")
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
      val bytes: InputStream =
        ByteArrayInputStream(japaneseName.toByteArray(Charset.forName(System.getProperty("native.encoding"))))
      System.setIn(bytes)
      Hello4.main(emptyArray())
      val expectedOutput: List<String> = listOf("お名前は?", japaneseName + "さん、こんにちは")
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link Calc4}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Calc4}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Calc4クラス")
  inner class Calc4Test {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testCalc4Main() {
      val inputValue = "128"
      val bytes: InputStream = ByteArrayInputStream(inputValue.toByteArray())
      System.setIn(bytes)
      Calc4.main(emptyArray())
      val expectedOutput: List<String> = listOf(
        "整数を入力してください",
        "2倍すると" + inputValue.toInt() * 2
      )
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link ExeCalc}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link ExeCalc}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("ExeCalcクラス")
  inner class ExeCalcTest {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testExeCalcMain() {
      ExeCalc.main(emptyArray())
      val expectedOutput: List<String> = listOf(
        "127 + 128 = " + (127 + 128),
        "100 - 68 = " + (100 - 68),
        "16 * 16 = " + (16 * 16),
        "10 / 100 = " + (10 / 100),
        "2005 % 4 = " + (2005 % 4)
      )
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link Hello2}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Hello2}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Hello2クラス")
  inner class Hello2Test {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testHello2Main() {
      Hello2.main(emptyArray())
      val expectedOutput = listOf("Hello!", "How you doing?")
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link Hello3}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Hello3}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Hello3クラス")
  inner class Hello3Test {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testHello3Main() {
      Hello3.main(emptyArray())
      val expectedOutput: List<String> = listOf("こんにちは", "元気ですか？")
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link Calc5}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Calc5}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Calc5クラス")
  inner class Calc5Test {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testCalc5Main() {
      Calc5.main(emptyArray())
      val expectedOutput: List<String> = listOf(
        (7 / 4.0).toString(),
        (7 / 3.0).toString()
      )
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link DebugTraining1}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link DebugTraining1}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("DebugTraining1クラス")
  inner class DebugTraining1Test {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testDebugTraining1Main() {
      DebugTraining1.main(emptyArray())
      val expectedOutput: List<String> = listOf(
        "Hello!",
        "How you doing?",
        "Okay thanks.",
        "How about you?"
      )
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link DebugTraining2}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link DebugTraining2}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("DebugTraining2クラス")
  inner class DebugTraining2Test {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testDebugTraining2Main() {
      DebugTraining2.main(emptyArray())
      val expectedOutput: List<String> = listOf(
        "こんにちは",
        "元気ですか？"
      )
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link Trapez}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Trapez}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Trapezクラス")
  inner class TrapezTest {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testTrapezMain() {
      Trapez.main(emptyArray())
      val expectedOutput = "台形の面積は" + (20 + 15) * 10 / 2 + "です"
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

  /**
   * {@link Laboratory}クラスのテストを行います。
   *
   * <p>
   * このクラスは、{@link Laboratory}クラスの各メソッドが正しく動作するかをテストします。
   * </p>
   */
  @Nested
  @DisplayName("Laboratoryクラス")
  inner class LaboratoryTest {
    @DisplayName("mainメソッドのテスト")
    @Test
    fun testLaboratoryMain() {
      val className = "Laboratory"

      try {
        val clazz = Class.forName(className)
        val method = clazz.getMethod("main", Array<String>::class.java)
        method.invoke(null, emptyArray<String>())
      }
      catch (e: ClassNotFoundException) {
        assumeTrue(false, "$className クラスが見つかりません。")
      }

      val expectedOutput: List<String> = listOf(
        (-10 + -10).toString(),
        (-10 * 0).toString(),
        (0 / (1 * 2)).toString(),
        (8 % -3).toString()
      )
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }
}
