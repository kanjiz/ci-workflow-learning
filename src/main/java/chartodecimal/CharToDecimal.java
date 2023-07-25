public class CharToDecimal {
  public static void main(String[] args) {
    int num;
    char ch;

    ch = 'A'; // 値の設定
    num = ch; // 整数値

    /* 文字の'X' は,10進数 xxxxx と表示する */
    System.out.println("文字の \'" + ch + "\' は,10進数で " + num);
  }
}
