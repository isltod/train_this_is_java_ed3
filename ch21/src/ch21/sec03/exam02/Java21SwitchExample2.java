package ch21.sec03.exam02;

public class Java21SwitchExample2 {
	public static void main(String[] args) {
		mthod(1);
		mthod(2);
		mthod(3);
		mthod("a");
		mthod("b");
		mthod("c");
		mthod(null);
	}

	private static void mthod(Object object) {
		int score = switch (object) {
		case Integer i when i == 1 -> 90;
		case Integer i when i == 2 -> 80;
		case Integer i -> 70;
		case String s when s.equals("a") -> 90;
		case String s when s.equals("b") -> 80;
		case String s -> 70;
		case null, default -> 0;
		};
		System.out.println(score);
	}
}
