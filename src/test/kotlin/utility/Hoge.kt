package utility

import io.kotest.core.spec.style.FunSpec
import org.json.JSONObject
import java.nio.charset.StandardCharsets

class Hoge : FunSpec({
  val fileName = "chapter03.json"
  val json = javaClass.classLoader.getResource(fileName)?.readText(
    StandardCharsets.UTF_8
  )
    ?: throw Exception("File not found: $fileName")
  val jsonArray = JSONObject(json).getJSONArray("classes")
  val classDataList = mutableListOf<ClassData>()

  println(jsonArray)

  jsonArray.filterIsInstance<JSONObject>().forEach {
    val jsonObject = it
    val className = jsonObject.getString("className")
    val methods = mutableListOf<MethodData>()

    jsonObject.getJSONArray("methods").forEach {
      val methodJsonObject = it as JSONObject
      val methodName = methodJsonObject.getString("methodName")
      val returnType = methodJsonObject.getString("returnType")
      val parameters = mutableListOf<ParameterData>()

      methodJsonObject.getJSONArray("parameters").forEach {
        val parameterJsonObject = it as JSONObject
        val name = parameterJsonObject.getString("name")
        val type = parameterJsonObject.getString("type")

        parameters.add(ParameterData(name, type))
      }

      val expected = methodJsonObject.getJSONArray("expected").map { it.toString() }

      methods.add(MethodData(methodName, returnType, parameters, expected))
    }

    classDataList.add(ClassData(className, methods))

  }

  classDataList.forEachIndexed { index, classData ->
    println("Class $index: $classData")
  }

  test("hoge") {
    println("hoge")
  }
})
