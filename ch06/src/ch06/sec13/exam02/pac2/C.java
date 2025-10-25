package ch06.sec13.exam02.pac2;

// 패키지가 달라지니 일단 import 들어가고...
import ch06.sec13.exam02.pac1.A;

public class C {
	public static void main(String[] args) {
		A a1 = new A(true);
		// 패키지가 다르니 default 접근 제한에도 걸린다...
		A a2 = new A(1);
		A a3 = new A("문자열");
		
	}
}
