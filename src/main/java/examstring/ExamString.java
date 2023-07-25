public class ExamString {
  public static void main(String[] args) {

    /* ① str1 = "Hello!" */
    String str1;
    str1 = "Hello!";
    System.out.println("① str1 = " + str1 + "\n");

    /* ② str2 = str1 */
    String str2 = str1;
    System.out.println("② str1 = " + str1);
    System.out.println("② str2 = " + str2 + "\n");

    /* ③ str1 = "How you doing?" */
    str1 = "How you doing?";
    System.out.println("③ str1 = " + str1);
    System.out.println("③ str2 = " + str2);
  }
}
