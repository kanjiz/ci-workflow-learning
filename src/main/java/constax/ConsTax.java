/*
 * 消費税込みの金額を求めるプログラム
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsTax {
  public static void main(String[] args) throws IOException {
    int money; // 金額入力のエリア

    /* 入力の準備 */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /* 税込み金額の算出と表示 */
    System.out.println("金額を入力してください");
    money = Integer.parseInt(br.readLine()); // 金額の入力
    money *= 1.08; // 税込み金額を求める
    System.out.println("税込み\\" + +money); // 税込み金額を表示する
  }
}
