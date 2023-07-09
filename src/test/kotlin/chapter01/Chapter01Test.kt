package chapter01

import PrintStreamExtension
import TestUtils
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Chapter01Test : FunSpec({
  context("第一章") {
    val outputCaptor = PrintStreamExtension()
    val bytes = ByteArrayOutputStream()
    val out = System.out
    beforeEach {
      println("beforeEach")
      System.setOut(PrintStream(bytes))
    }

    afterEach {
      System.setOut(out)
      bytes.reset()
      println("afterEach")
    }

    test("Helloクラスのmainメソッドのテスト") {
      Hello.main(emptyArray())
      val expectedOutput = "Hello!"
//    TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)

      TestUtils.assertOutput(bytes.toString().trim(), expectedOutput)
//    bytes.toString().trim() shouldBe expectedOutput
    }

    test("HelloJavaクラスのmainメソッドのテスト") {
      HelloJava.main(emptyArray())
      val expectedOutput = "Hello Java world"
//    TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    TestUtils.assertOutput(bytes.toString().trim(), expectedOutput)
//      bytes.toString().trim() shouldBe expectedOutput
    }
  }

})
