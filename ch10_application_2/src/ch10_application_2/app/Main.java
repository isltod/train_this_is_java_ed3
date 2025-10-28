package ch10_application_2.app;

import ch10_module_1.pack1.A;
import ch10_module_1.pack2.B;
import ch10_module_2.pack3.C;

public class Main {
	public static void main(String[] args) {
		A a = new A();
		a.method();
		B b = new B();
		b.method();
		C c = new C();
		c.method();
	}
}
