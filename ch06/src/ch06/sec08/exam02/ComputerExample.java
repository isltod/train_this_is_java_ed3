package ch06.sec08.exam02;

public class ComputerExample {
	public static void main(String[] args) {
		Computer myCom = new Computer();
		// 일단 아래처럼 리터럴, 배열 다 된다...
		int result = myCom.sum(1, 2, 3);
		System.out.println("result1: " + result);
		result = myCom.sum(1, 2, 3, 4, 5);
		System.out.println("result2: " + result);
		result = myCom.sum(new int[] {1, 2, 3, 4, 5});
		System.out.println("result3: " + result);
		int[] values = {1, 2, 3, 4, 5};
		result = myCom.sum(values);
		System.out.println("result4: " + result);
		// 다만 아래처럼 날짝 배열 내용만 넣을 수는 없다...
		// result = myCom.sum({1, 2, 3, 4, 5});
	}
}
