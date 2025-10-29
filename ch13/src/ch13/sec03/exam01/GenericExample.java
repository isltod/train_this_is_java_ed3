package ch13.sec03.exam01;

public class GenericExample {
	//뒤에 올 매개변수는 generic이다...리턴 타입은 generic을 넣은 Box다... 
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.set(t);
		return box;
	}
	public static void main(String[] args) {
		Box<Integer> box1 = boxing(100);
		Integer intValue = box1.get();
		System.out.println(intValue);
		
		Box<String> box2 = boxing("홍길동");
		String strValue = box2.get();
		System.out.println(strValue);
	}
}
