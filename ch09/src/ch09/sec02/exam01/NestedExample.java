package ch09.sec02.exam01;

public class NestedExample {
	// 바깥 객체는 보통 하던 식으로..
	Outer outer = new Outer();
	// 안쪽 객체가 좀 다른데...앞은 클래스, 뒤는 객체
	Outer.Inner inner = outer.new Inner();
}
