package ch09.sec03.exam01;

public class Outer {
	static class Inner {
		int field1 = 1;
		static int field2 = 2;
		Inner() {
			// TODO Auto-generated constructor stub
			System.out.println("안쪽 클래스 생성자 실행");
		}
		void method1() {
			System.out.println("안쪽 클래스 메소드 1 실행");
		}
		static void method2() {
			System.out.println("안쪽 클래스 메소드 2 실행");
		}
	}
}
