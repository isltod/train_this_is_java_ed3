package ch08.sec07;

public class ServiceExample {
	public static void main(String[] args) {
		Service service = new ServiceImpl();
		service.defaultMethod1();
		System.out.println();
		service.defaultMethod2();
		System.out.println();
		// 반면에 인터페이스의 정적 메소드는 인터페이스에서 바로 호출
		Service.staticMethod1();
		System.out.println();
		Service.staticMethod2();
	}
}
