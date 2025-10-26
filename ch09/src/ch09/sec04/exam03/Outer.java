package ch09.sec04.exam03;

public class Outer {
	public void method1(int arg) {
		int var = 1;
		class Inner {
			void method2() {
				System.out.println("arg: " + arg);
				System.out.println("var: " + var);
			}
			// 로컬 변수를 수정하면 안된다네...거기다 오류 마크도 엉뚱한데서 나오네...지옥이야...
			arg = 2;
			var = 2;
		}
	}
}
