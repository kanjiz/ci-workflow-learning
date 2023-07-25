public class Variable3 {
  public static void main(String[] args) {
    int a; // ① 変数aの宣言
    int b; // 変数bの宣言

    System.out.println("a = 5 * 15"); // タイトル表示
    a = 5 * 15; // ② 計算結果を代入
    System.out.println("a = " + a); // aの値を表示

    System.out.println("b = a"); // タイトル表示
    b = a; // ③ 別の変数の値を代入
    System.out.println("a = " + a); // aの値を表示
    System.out.println("b = " + b); // bの値を表示

    System.out.println("a = a + b"); // タイトル表示
    a = a + b; // ④ 変数を使用した計算結果を代入
    System.out.println("a = " + a); // aの値を表示
    System.out.println("b = " + b); // bの値を表示
  }
}
