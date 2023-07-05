import java.io.*;
import java.nio.charset.Charset;

public class Hello4 {
  public static void main(String[] args) throws IOException {

    /* 入力の準備 */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName(System.getProperty("native.encoding"))));

    /* プロンプト（入力を促すメッセージ）の表示 */
    System.out.println("お名前は?");

    /* キーボードから入力 */
    String name = br.readLine();

    /* 入 力 さ れ た 文 字 列 + あ い さ つ 文 の 表 示 */
    System.out.println(name + "さん、こんにちは");

  }
}
