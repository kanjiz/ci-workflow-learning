package chapter03

import utility.ClassData
import utility.TestDataManager
import utility.TestLabelGenerator
import utility.UnitTestRunner
import io.kotest.core.spec.style.FunSpec

class Chapter03Test : FunSpec({
  val chapter = TextbookChapter.CHAPTER_3
  val unitTestRunner = UnitTestRunner()

  context(chapter.chapterTitle) {
    val testDataManager = TestDataManager(chapter.testDataFileName)
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
