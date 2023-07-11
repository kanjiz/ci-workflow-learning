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

//      .filter { it.getString("chapter") == "1" }
      .map {
        TestData(
          it.getString("chapter"),
          it.getString("className"),
          it.getString("methodName"),
          it.getJSONArray("input").joinToString(", "),
          it.getJSONArray("expected").joinToString(", ")
        )
      }
      .toCollection(testDataMutableList)
  }

  fun getTestDataList(): List<TestData> {
    return testDataMutableList.toList()
  }
}
