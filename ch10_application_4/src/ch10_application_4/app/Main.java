package ch10_application_4.app;

import ch10_module_1.pack1.A;
// module-info에 transitive 한 덕에 requires로 module2를 넣지 않아도 이렇게 import가 되긴 한다...
//하지만 transitive 넣어야 하고, 일일히 다 build path 설정해줘야 하니 뭔 이익이 있다는 건지 모르겠다...
import ch10_module_2.pack3.C;

public class Main {
	public static void main(String[] args) {
		A a = new A();
		a.method();
		
		C c = new C();
		c.method();
		
		C result = a.getC();
		result.method();
	}
}
