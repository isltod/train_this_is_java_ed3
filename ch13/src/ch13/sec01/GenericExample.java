package ch13.sec01;

public class GenericExample {
	public static void main(String[] args) {
		Box<String> box1 = new Box<>();
		box1.contents = "안녕하세요.";
		String str = box1.contents;
		System.out.println(str);
		
		Box<Integer> box2 = new Box<>();
		box2.contents = 100;
		int value = box2.contents;
		System.out.println(value);
	}
}
