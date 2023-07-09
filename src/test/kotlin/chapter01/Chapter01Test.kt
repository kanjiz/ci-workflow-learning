package chapter01

import PrintStreamExtension
import TestUtils
import io.kotest.core.spec.style.FunSpec

class Chapter01Test : FunSpec({
  context("第一章") {
    val outputCaptor = PrintStreamExtension()
    extension(outputCaptor)

    test("Helloクラスのmainメソッドのテスト") {
      Hello.main(emptyArray())
      val expectedOutput = "Hello!"
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }

    test("HelloJavaクラスのmainメソッドのテスト") {
      HelloJava.main(emptyArray())
      val expectedOutput = "Hello Java world"
      TestUtils.assertOutput(outputCaptor.getOutput(), expectedOutput)
    }
  }

})
