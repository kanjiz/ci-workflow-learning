package chapter02

import PrintStreamExtension
import TestDataManager
import TestLabelGenerator
import io.kotest.assertions.fail
import io.kotest.core.spec.style.FunSpec

/**
 * テキストの第二章に記載された各クラスのテストを行います。
 *
 * <p>
 * このクラスは、テキストの第二章に記載された各クラスの各メソッドが正しく動作するかをテストします。
 * </p>
 */
class Chapter02Test : FunSpec({

  context("第二章") {
    val outputCaptor = PrintStreamExtension()
    extension(outputCaptor)

    val fileName = "chapter02.json"
    val testDataList = TestDataManager(fileName).getTestDataList()
    testDataList.forEach {

      val testLabel = TestLabelGenerator.generateLabel(it)
      test(testLabel) {
        val didMethodExecute = MethodExecutor.executeMethod(it)
        if (!didMethodExecute) {
          fail("Method not found: ${it.className} ${it.methodName}")
        }
        TestUtils.assertOutput(outputCaptor.getOutput(), it.expected)
      }
    }
  }
})
