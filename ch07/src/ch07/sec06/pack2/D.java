package ch07.sec06.pack2;

import ch07.sec06.pack1.A;

public class D extends A {
	public D() {
		// protected라도 상속 관계에서는 사용할 수 있는데, 이런 식으로...
		super();
	}
	
	public void method1() {
		// "나"는 상속자니까 나를 통해서는 protected를 부를 수 있고...
		this.field = "value";
		this.method();
	}
	public void method2() {
		// 생성자도 protected이므로 이런 식으로 만들 수도 없고, 
		A a = new A();
		// 당연히 이런식으로 호출도 안되고...
		a.field = "value";
		a.method();
	}
}
