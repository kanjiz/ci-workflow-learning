package chapter01

import io.kotest.core.spec.style.FunSpec
import utility.TestDataManager
import utility.TestLabelGenerator
import utility.UnitTestRunner

/**
 * 第一章のテストを実行するためのクラスです。
 */
class Chapter01Test : FunSpec({
  
  /**
   * 第一章のテストをグループ化しています。
   */
  context("第一章") {
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
