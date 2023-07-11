import io.kotest.assertions.fail
import io.kotest.core.factory.TestFactory
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.funSpec
import io.kotest.matchers.shouldNotBe


class MySpec : FunSpec({
  context("第一章") {
    val outputCaptor = PrintStreamExtension()
    extension(outputCaptor)

    val testDataList = TestDataManager("testData.json").getTestDataList()
    testDataList.forEach {
      test("${it.className} ${it.methodName}") {
        val didMethodExecute = executeMethod(it.className, it.methodName)
        if (!didMethodExecute) {
          fail("Method not found: ${it.className} ${it.methodName}")
        }
        TestUtils.assertOutput(outputCaptor.getOutput(), it.expected)
      }
    }

//    include(myTestFactory("foo"))
//    include(myTestFactory("bar"))
  }
})



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

private fun myTestFactory(s: String): TestFactory {
  return funSpec {
    context("test $s") {
      test("should not be equal to foo") {
        s shouldNotBe "foo"
      }
    }
  }
}
