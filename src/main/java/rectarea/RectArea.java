import java.io.*;

public class RectArea {
  public static void main(String[] args) throws IOException {
    int height; // 変数の宣言（縦）
    int width; // 変数の宣言（横）
    int area; // 変数の宣言（面積）

    /* 入 力 の 準 備 */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /* 縦 の 長 さ の 入 力 */
    System.out.println("縦の長さを入力してください");
    height = Integer.parseInt(br.readLine()); // 縦の値を入力

    /* 横の長さの入力 */
    System.out.println("横の長さを入力してください");
    width = Integer.parseInt(br.readLine()); // 横の値を入力

    /* 面積を求めて表示 */

    area = height * width; // 面積を求める
    System.out.println("面積は" + area); // 面積を表示する
  }
}
