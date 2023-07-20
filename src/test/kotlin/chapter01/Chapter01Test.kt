package chapter01

import TextbookChapter
import io.kotest.core.spec.style.FunSpec
import utility.ClassData
import utility.SimpleTestData
import utility.TestDataManager
import utility.TestLabelGenerator
import utility.UnitTestRunner

/**
 * 第一章のテストを実行するためのクラスです。
 */
class Chapter01Test : FunSpec({
  val chapter = TextbookChapter.CHAPTER_1
  /**
   * 第一章のテストをグループ化しています。
   */
  context(chapter.chapterTitle) {
    val unitTestRunner = UnitTestRunner()
    val testDataManager = TestDataManager(chapter.testDataFileName)
    val testDataList = testDataManager.getTestDataList()

    if (testDataList[0] is SimpleTestData) {
      testDataList.forEach {
        val simpleTestData = it as SimpleTestData
        val testLabel = TestLabelGenerator.generateLabel(simpleTestData)
        test(testLabel) {
          unitTestRunner.runTest(simpleTestData)
        }
      }
    } else {
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
  }
})
