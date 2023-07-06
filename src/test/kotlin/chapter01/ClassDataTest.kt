package chapter01

import TestDataManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class ClassDataTest {

  @Test
  fun testCalc1Main() {
    println("testCalc1Main")


  }

  companion object {
    @JvmStatic
    @BeforeAll
    fun beforeAll() {
      println("beforeAll")
      val testDataManager = TestDataManager("testData.json")
      val testDataList = testDataManager.getTestDataList()
      println(testDataList)
    }
  }
}
