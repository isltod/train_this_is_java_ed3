package ch09.sec03.exam01;

public class NestedExample {
	public static void main(String[] args) {
		Outer.Inner inner = new Outer.Inner();
		// 인스턴스 멤버는 당연히 되고
		System.out.println(inner.field1);
		inner.method1();
		// 정적 멤버도 되긴 하는데, 역시 형식은 A.B.
		System.out.println(Outer.Inner.field2);
		Outer.Inner.method2();
		
		// 그런데 문제가 정적 멤버도 그냥 인스턴스 멤버처럼 되는 모양인데...
		System.out.println(inner.field2);
		inner.method2();
	}
}
