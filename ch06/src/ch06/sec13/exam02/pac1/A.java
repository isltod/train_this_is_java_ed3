package ch06.sec13.exam02.pac1;

public class A {
	public A(boolean b) {
		// TODO Auto-generated constructor stub
	}
	A(int b) {
		// TODO Auto-generated constructor stub
	}
	private A(String s) {
		// TODO Auto-generated constructor stub
	}
	
	A a1 =  new A(true);
	A a2 = new A(1);
	// 같은 클래스 안이니까 심지어 이것까지 다 된다...
	A a3 = new A("문자열");
}
