package ch09.sec02.exam02;

public class Outer {
	class Inner {
		int field1 = 1;
		static int field2 = 2;
		public Inner() {
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
	void useInner() {
		Inner inner = new Inner();
		System.out.println(inner.field1);
		inner.method1();
		// 하지만 정적 필드나 메소드는 정적 멤버 답게 클래스 이름으로...
		System.out.println(Inner.field2);
		Inner.method2();
	}
}
