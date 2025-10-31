package ch17.sec10;

import java.util.Arrays;

public class AggregateExample {
	public static void main(String[] args) {
		int[] intArr = {1, 2, 3, 4, 5};
		
		long count = Arrays.stream(intArr)
				.filter(n -> n % 2 == 0)
				.count();
		System.out.println("2의 배수의 갯수: " + count);
		
		int first = Arrays.stream(intArr)
				.filter(n -> n % 3 == 0)
				.findFirst()
				.getAsInt();
		System.out.println("첫 번째 3의 배수: " + first);
	}
}
