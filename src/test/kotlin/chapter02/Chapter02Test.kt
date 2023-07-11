package chapter02

import PrintStreamExtension
import TestDataManager
import io.kotest.assertions.fail
import io.kotest.core.spec.style.FunSpec

class Chapter02Test : FunSpec({

  context("第二章") {
    val outputCaptor = PrintStreamExtension()
    extension(outputCaptor)

    val fileName = "chapter02.json"
    val testDataList = TestDataManager(fileName).getTestDataList()
    testDataList.forEach {
      test("${it.className} ${it.methodName}") {
        val didMethodExecute = MethodExecutor.executeMethod(it.className, it.methodName)
        if (!didMethodExecute) {
          fail("Method not found: ${it.className} ${it.methodName}")
        }
        TestUtils.assertOutput(outputCaptor.getOutput(), it.expected)
      }
    }
  }
})
