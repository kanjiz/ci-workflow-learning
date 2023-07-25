import java.io.*;

public class InputVariable {
  public static void main(String[] args) throws IOException {
    String name; // 名前を記憶する領域（文字列）
    int age; // 年齢を記憶する領域（整数）
//    age = 0;
    /* 入力の準備 */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /* 文字列（名前）の入力 */
    System.out.println("名前を入力してください");
    name = br.readLine(); // 名前の入力

    /* 整数の入力と変換 */
    System.out.println(name + "さんは、何歳ですか?");
    age = Integer.parseInt(br.readLine()); // 年齢の入力

    /* 入力した値を計算に利用 */
    System.out.println(name + "さんは、若く見えますね");
    System.out.println((age - 5) + "歳くらいだと思いました");
  }
}
