package ch10_module_1.pack1;

import ch10_module_2.pack3.C;

public class A {
	public void method() {
		System.out.println("A-method 실행");
	}
	// transitive로 만들면 이런 코드를 다 넣어줘야 하나? 귀찮은데...
	public C getC() {
		C c = new C();
		return c;
	}
}
