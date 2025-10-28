package ch12.ex.problem10;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("");
		for (int i = 0; i <= 100; i++) {
			str.append(i);
		}
		str.toString();
		System.out.println(str);
	}
}
