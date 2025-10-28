package ch10_application_3.app;

import ch10_module_1.pack1.A;
//module-info의 exports에서 제외했더니 왼쪽 익스플로러에서 패키지와 클래스는 다보이는데도 import하니 오류 발생
//이 정도면 은닉이 아니라 금지라고 하는게 맞을 듯...
import ch10_module_1.pack2.B;

public class Main {
	public static void main(String[] args) {
		A a = new A();
		a.method();
		
		B b = new B();
		b.method();
	}
}
