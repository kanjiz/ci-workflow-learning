package chapter01

import TestClassDataManager
import org.junit.jupiter.api.Test

class ClassDataTest {
  @Test
  fun testCalc1Main() {
    val testClassDataManager = TestClassDataManager("testClassData.json")
    val testClassDataList = testClassDataManager.getTestClassDataList()
    println(testClassDataList)
  }
}
