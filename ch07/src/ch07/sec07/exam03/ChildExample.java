package ch07.sec07.exam03;

public class ChildExample {
	public static void main(String[] args) {
		// 먼저 자식 객체를 만들면서 바로 부모로 자동 타입 변환
		Parent parent = new Child();
		
		// 부모 형식으로 필드와 메소드 이용
		parent.filed1 = "data1";
		parent.method1();
		parent.method2();
		
		// 이 상태에서는 자식이 갖고 있는 field2와 method3은 이용 못하고...
		parent.filed2 = "data2";
		parent.method3();
		
		// 다시 자식으로 강제 타입 변환해서 필드와 메소드 이용
		Child child = (Child) parent;
		child.field2 = "data2";
		child.method1();
		child.method2();
		child.method3();
	}
}
