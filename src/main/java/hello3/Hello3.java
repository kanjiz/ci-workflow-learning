public class Hello3 {
  public static void main(String[] args) {
		System.out.println("こんにちは");	// メッセージの表示
 		System.out.println("元気ですか？");
	}
}

/*----------

>javac Hello3.java
Hello3.java:4: エラー: '\u3000'は不正な文字です
　              System.out.println("元気ですか？");
^
エラー1個

----------*/
