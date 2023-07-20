package chapter03

import utility.TestDataManager
import utility.TestLabelGenerator
import utility.UnitTestRunner
import io.kotest.core.spec.style.FunSpec
import utility.ClassData

class Chapter03Test : FunSpec({

  val unitTestRunner = UnitTestRunner()

  context("第三章") {
    val testDataManager = TestDataManager("chapter03.json")
    val testDataList = testDataManager.getTestDataList()

    testDataList.forEach {
      val classData = it as ClassData
      val className = classData.className
      classData.methods.forEach { method ->
        val testLabel = TestLabelGenerator.generateLabel(className, method.methodName)
        test(testLabel) {
          unitTestRunner.runTest(className, method)
        }
      }
    }
  }
})
