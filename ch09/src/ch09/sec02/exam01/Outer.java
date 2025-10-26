package ch09.sec02.exam01;

public class Outer {
	// 포함 클래스 선언...뒤에 ; 도 없다..
	class Inner {}
	
	Inner inner = new Inner();
	
	public Outer() {
		// TODO Auto-generated constructor stub
		Inner inner = new Inner();
	}
	
	public void method() {
		Inner inner = new Inner();
	}
}
