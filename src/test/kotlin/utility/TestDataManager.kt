package utility

import org.json.JSONObject
import java.nio.charset.StandardCharsets

class TestDataManager(private val fileName: String) {
  private val testDataMutableList = mutableListOf<TestData>()

  init {
    /*
     * テストデータを読み込み、テストデータのリストを作成します。
     * テストデータは、src/test/resources/に記載されています。
     */
    val data = javaClass.classLoader.getResource(fileName)?.readText(StandardCharsets.UTF_8)
      ?: throw Exception("File not found: $fileName")
    val jsonArray = JSONObject(data).getJSONArray("classes")

    jsonArray.filterIsInstance<JSONObject>()
      .map {
        TestData(
          it.getString("className"),
          it.getString("methodName"),
          it.getJSONArray("input").map(Any::toString).toList(),
          it.getJSONArray("expected").map(Any::toString).toList()
        )
      }
      .toCollection(testDataMutableList)
  }

  fun getTestDataList(): List<TestData> {
    return testDataMutableList.toList()
  }
}
