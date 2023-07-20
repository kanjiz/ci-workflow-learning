enum class TextbookChapter(
  val chapterNumber: Int,
  val chapterTitle: String,
  val testDataFileName: String
) {
  CHAPTER_1(1, "第一章", "chapter01.json"),
  CHAPTER_2(2, "第二章", "chapter02.json"),
  CHAPTER_3(3, "第三章", "chapter03.json"),
  CHAPTER_4(4, "第四章", "chapter04.json"),
  CHAPTER_5(5, "第五章", "chapter05.json"),
  CHAPTER_6(6, "Object-Oriented Programming", "chapter06.json"),
  CHAPTER_7(7, "Inheritance and Polymorphism", "chapter07.json"),
  CHAPTER_8(8, "Exceptions and Error Handling", "chapter08.json"),
  CHAPTER_9(9, "File Input and Output", "chapter09.json"),
  CHAPTER_10(10, "Recursion", "chapter10.json"),
  CHAPTER_11(11, "Sorting and Searching", "chapter11.json")
}
