package ch13.sec02.exam03;

public class GenericExample {
	public static void main(String[] args) {
		Box<String> box1 = new Box<>();
		Box<String> box2 = new Box<>();
		box1.content = "100";
		box2.content = "100";
		//box의 content는 String이니까, box.comapare 메소드에서 equals로 비교할 때 String.equals가 된다.
		boolean result = box1.compare(box2);
		System.out.println("result: " + result);
	}
}
