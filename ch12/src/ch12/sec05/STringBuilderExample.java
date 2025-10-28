package ch12.sec05;

public class STringBuilderExample {
	public static void main(String[] args) {
		String data = new StringBuilder("DEF")
				.append("DEF")
				.insert(0, "ABC")
				.delete(3, 4)
				.toString();
		System.out.println(data);
	}
}
