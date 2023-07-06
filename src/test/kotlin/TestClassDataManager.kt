import org.json.JSONObject
import java.nio.charset.StandardCharsets

class TestClassDataManager(private val fileName: String) {
  private val testClassDataList = mutableListOf<TestClassData>()

  init {
    val data = javaClass.classLoader.getResource(fileName)?.readText(StandardCharsets.UTF_8)
    val jsonArray = JSONObject(data).getJSONArray("classes")

    jsonArray.filterIsInstance<JSONObject>()
      .filter { it.getString("chapter") == "1" }
      .map {
        TestClassData(
          it.getString("chapter"),
          it.getString("className"),
          it.getString("methodName"),
          it.getJSONArray("input").joinToString(", "),
          it.getJSONArray("expected").joinToString(", ")
        )
      }
      .toCollection(testClassDataList)
  }

  fun getTestClassDataList(): List<TestClassData> {
    return testClassDataList.toList()
  }
}
