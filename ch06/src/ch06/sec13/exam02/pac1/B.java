package ch06.sec13.exam02.pac1;

public class B {
	public static void main(String[] args) {
		A a1 = new A(true);
		A a2 = new A(1);
		// private 생성자는 같은 패키지 안이라도 안된다...
		A a3 = new A("문자열");
	}
}
