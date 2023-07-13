package utility

import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.Charset

object MethodExecutor {
  fun executeMethod(testData: TestData): Boolean {
    val nativeEncoding: Charset = Charset.forName(System.getProperty("native.encoding"))

    return try {
      val clazz = Class.forName(testData.className)
      val method = clazz.getMethod(testData.methodName, Array<String>::class.java)
      val inputList = testData.input.split(",")
      inputList.forEach {
        val bytes: InputStream =
          ByteArrayInputStream(it.toByteArray(nativeEncoding))
        System.setIn(bytes)
      }
//      val bytes: InputStream =
//        ByteArrayInputStream(testData.input.toByteArray(Charset.forName(System.getProperty("native.encoding"))))
//      System.setIn(bytes)
      method.invoke(null, emptyArray<String>())

      true
    } catch (e: ClassNotFoundException) {
      false
    }
  }

  fun executeMethod(className: String, methodName: String): Boolean {
    return try {
      val clazz = Class.forName(className)
      val method = clazz.getMethod(methodName, Array<String>::class.java)
      method.invoke(null, emptyArray<String>())
      true
    } catch (e: ClassNotFoundException) {
      false
    }
  }

  fun executeMethod(className: String, methodName: String, input: String): Boolean {
    return try {
      val clazz = Class.forName(className)
      val method = clazz.getMethod(methodName, Array<String>::class.java)
      method.invoke(null, emptyArray<String>())
      true
    } catch (e: ClassNotFoundException) {
      false
    }
  }
}
