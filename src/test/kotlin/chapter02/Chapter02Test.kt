package chapter02

import io.kotest.core.spec.style.FunSpec
import utility.TestDataManager
import utility.TestLabelGenerator
import utility.UnitTestRunner

/**
 * テキストの第二章に記載された各クラスのテストを行います。
 *
 * <p>
 * このクラスは、テキストの第二章に記載された各クラスの各メソッドが正しく動作するかをテストします。
 * </p>
 */
class Chapter02Test : FunSpec({

  context("第二章") {
    val unitTestRunner = UnitTestRunner()
    val testDataManager = TestDataManager("chapter02.json")
    val testDataList = testDataManager.getTestDataList()

    testDataList.forEach {
      val testLabel = TestLabelGenerator.generateLabel(it)
      test(testLabel) {
        unitTestRunner.runTest(it)
      }
    }
  }
})
