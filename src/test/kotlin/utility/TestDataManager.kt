package utility

import java.nio.charset.StandardCharsets
import kotlinx.serialization.json.Json

class TestDataManager(fileName: String) {
  private val simpleTestDataList: List<SimpleTestData>?
  private val testDataList: List<ClassData>?

  private fun loadSimpleTestData(fileName: String): List<SimpleTestData> {
    val data =
      javaClass.classLoader.getResource(fileName)?.readText(StandardCharsets.UTF_8)
        ?: throw Exception("File not found: $fileName")
    return Json.decodeFromString(data)
  }

  private fun loadTestData(fileName: String): List<ClassData> {
    val data =
      javaClass.classLoader.getResource(fileName)?.readText(StandardCharsets.UTF_8)
        ?: throw Exception("File not found: $fileName")
    return Json.decodeFromString(data)
  }

  init {
    /*
     * テストデータを読み込み、テストデータのリストを作成します。
     * テストデータは、src/test/resources/に記載されています。
     */
    simpleTestDataList =
      if (fileName in listOf("chapter01.json", "chapter02.json")) {
        loadSimpleTestData(fileName)
      } else {
        null
      }

    testDataList =
      if (simpleTestDataList == null) {
        loadTestData(fileName)
      } else {
        null
      }
  }

  fun getTestDataList(): List<Any> {
    return when {
      simpleTestDataList != null -> simpleTestDataList
      testDataList != null -> testDataList
      else -> emptyList()
    }
  }
}
