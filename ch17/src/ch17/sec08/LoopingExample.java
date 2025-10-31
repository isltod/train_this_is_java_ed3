package ch17.sec08;

import java.util.Arrays;

public class LoopingExample {
	public static void main(String[] args) {
		int[] intArr = {1, 2, 3, 4, 5};
		
		//배열은 Arrays 클래스의 정적 메소드 이용
		int total = Arrays.stream(intArr)
		.filter(a -> a % 2 == 0)
		.peek(n -> System.out.println(n))	//여기서 끝내면 컴파일 에러가 난다...
		.sum();
		System.out.println("총합: " + total);
		
		Arrays.stream(intArr)
		.filter(a -> a % 2 == 0)
		.forEach(n -> System.out.println(n));
	}
}
