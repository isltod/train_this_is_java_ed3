package ch09.sec05.exam02;

public class Outer {
	String field = "Outer-field";
	
	void method() {
		System.out.println("Outer-method");
	}
	class Inner {
		String field = "Inner-field";
		void method() {
			System.out.println("Inner-method");
		}
		void print() {
			System.out.println(this.field);
			this.method();
			// 바깥 객체의 필드와 메소드는 이상하게 바깥 이름을...
			System.out.println(Outer.this.field);
			Outer.this.method();
		}
	}
	void useInner() {
		Inner inner = new Inner();
		inner.print();
	}
}
