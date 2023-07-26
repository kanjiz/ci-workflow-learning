public class Swap {
  public static void main(String[] args) {
    int valX, valY; // 2つの変数XとYの宣言
    int temp; // 作業エリアtempの宣言

    valX = 1000; // 例題データの設定
    valY = 500;
    System.out.println("入れ替え前");
    System.out.println("Xは" + valX);
    System.out.println("Yは" + valY);

    /* データの入れ替え */
    temp = valX; // ①
    valX = valY; // ②
    valY = temp; // ③

    System.out.println("入れ替え後");
    System.out.println("Xは" + valX);
    System.out.println("Yは" + valY);
  }
}
