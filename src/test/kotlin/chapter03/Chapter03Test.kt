package chapter03

import utility.TestDataManager
import utility.TestLabelGenerator
import utility.UnitTestRunner
import io.kotest.core.spec.style.FunSpec

class Chapter03Test : FunSpec({

  context("第三章") {
    val unitTestRunner = UnitTestRunner()
    val testDataManager = TestDataManager("chapter01.json")
    val testDataList = testDataManager.getTestDataList()

    testDataList.forEach {
      val testLabel = TestLabelGenerator.generateLabel(it)
      test(testLabel) {
        unitTestRunner.runTest(it)
      }
    }
  }
})
