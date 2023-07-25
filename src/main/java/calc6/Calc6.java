public class Calc6 {
  public static void main(String[] args) {
    int ans; // 結果の格納エリア
    int valA, valB; // 処理データ

    valA = 5; // ①
    valB = valA; // ②
    ans = valA + valB; // ③
    valA = ans * 2; // ④
    ans = valA + valB; // ⑤
    ans = ans * 2; // ⑥

    System.out.println("ans = " + ans);
  }
}
