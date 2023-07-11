object MethodExecutor {
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
