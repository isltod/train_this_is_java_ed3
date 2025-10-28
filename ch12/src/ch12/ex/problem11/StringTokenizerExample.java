package ch12.ex.problem11;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String data = "아이디/이름/패스워드";
		StringTokenizer st = new StringTokenizer(data, "/");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
