/*
 * Hello! How you doing? と表示するプログラム
 */
public class Hello2 {
  public static void main(String[] args) {
    System.out.println("Hello!"); // 1行目の表示
    System.out.println("How you doing?"); // 2行目の表示
  }
}
/* 「;」のつけ忘れ(7行目) */
/*----------

>javac Hello2.java
Hello2.java:7: エラー: ';'がありません
        System.out.println("Hello!")            // 1行目の表示
                                    ^
エラー1個

----------*/
