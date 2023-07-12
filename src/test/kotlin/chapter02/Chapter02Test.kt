package chapter02

import PrintStreamExtension
import TestDataManager
import TestLabelGenerator
import io.kotest.assertions.fail
import io.kotest.core.spec.style.FunSpec

/**
 * 第2章のテストを行うためのクラスです。
 */
class Chapter02Test : FunSpec({

  context("第二章") {
    val outputCaptor = PrintStreamExtension()
    extension(outputCaptor)

    val fileName = "chapter02.json"
    val testDataList = TestDataManager(fileName).getTestDataList()
    testDataList.forEach {

      val testLabel = TestLabelGenerator.generateLabel(it);
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
