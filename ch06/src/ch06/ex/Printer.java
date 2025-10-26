package ch06.ex;

public class Printer {
	public void println(int num) {
		System.out.println(num);
	}
	public void println(boolean bool) {
		System.out.println(bool);
	}
	public void println(Double num) {
		System.out.println(num);
	}
	public void println(String str) {
		System.out.println(str);
	}
	// Printer.println으로 사용하려면 위 메서드들을 다 public static 으로 선언
}
