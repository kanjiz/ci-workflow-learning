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

  jsonArray.forEach {
    val jsonObject = it as JSONObject
    val className = jsonObject.getString("className")
    val methods = mutableListOf<MethodData>()

    jsonObject.getJSONArray("methods").forEach {
      val methodJsonObject = it as JSONObject
      val methodName = methodJsonObject.getString("methodName")
      val returnType = getReturnTypeFromJsonOrDefault(methodJsonObject)
      val parameters = mutableListOf<ParameterData>()

      methodJsonObject.getJSONArray("parameters").forEach {
        val parameterJsonObject = it as JSONObject
        val name = parameterJsonObject.getString("name")
        val type = parameterJsonObject.getString("type")

        parameters.add(ParameterData.builder().name(name).type(type).build())
      }

      val expected = methodJsonObject.getJSONArray("expected").map(Any::toString)

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

/**
 * メソッドの戻り値の型を取得する。
 *
 * @param methodJsonObject メソッドのJSONオブジェクト
 * @return メソッドの戻り値の型
 *
 */
private fun getReturnTypeFromJsonOrDefault(methodJsonObject: JSONObject): String {
  // returnTypeキーが存在しない場合は、既定値を設定する。
  // returnTypeキーの値が空文字の場合は、既定値を設定する。e.g. "returnType": ""
  // returnTypeキーの値が空白文字の場合は、既定値を設定する。e.g. "returnType": " "
  return if (methodJsonObject.isNull("returnType") || methodJsonObject.getString("returnType")
      .isEmpty() || methodJsonObject.getString("returnType").isBlank()
  ) {
    "void" // 既定値を設定
  } else {
    methodJsonObject.getString("returnType")
  }
}
