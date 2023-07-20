package chapter02

import io.kotest.core.spec.style.FunSpec
import utility.SimpleTestData
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
  val chapter = TextbookChapter.CHAPTER_2

  context(chapter.chapterTitle) {
    val unitTestRunner = UnitTestRunner()
    val testDataManager = TestDataManager(chapter.testDataFileName)
    val testDataList = testDataManager.getTestDataList()

    testDataList.forEach {
      val simpleTestData = it as SimpleTestData
      val testLabel = TestLabelGenerator.generateLabel(simpleTestData)
      test(testLabel) {
        unitTestRunner.runTest(simpleTestData)
      }
    }
  }
})
