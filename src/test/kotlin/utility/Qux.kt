package utility

import io.kotest.core.spec.style.FunSpec
import kotlinx.serialization.json.Json

class Qux : FunSpec({
  val testDataFileName = "chapter03.json"

  val data = javaClass.classLoader.getResource(testDataFileName)?.readText(Charsets.UTF_8)
    ?: throw Exception("File not found: $testDataFileName")

  val classDataList = Json.decodeFromString<List<ClassData>>(data)

  classDataList.forEachIndexed { index, classData ->
    println("Class $index: $classData")
  }
  
  test("qux") {
    println("qux")
  }
})
