package ch12.sec06;

public class BoxingUnboxingExample {
	public static void main(String[] args) {
		//Boxing
		Integer obj = 10000;
		System.out.println("value: " + obj.intValue());
		System.out.println("하지만 사실은:" + obj.toString());
		//Unboxing
		int value = obj;
		System.out.println("value: " + value);
		//연산 자동 Unboxing
		int result = obj + 100;
		System.out.println("result: " + result);
	}
}
