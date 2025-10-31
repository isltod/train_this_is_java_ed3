package ch17.sec09;

import java.util.Arrays;

public class MatchingExample {
	public static void main(String[] args) {
		int[] intArr = {2, 4, 6};
		
		//allMatch부터
		boolean result = Arrays.stream(intArr)
				.allMatch(a -> a % 2 == 0);		//각 요소가 match인지는 내가 넣어줘야 하고, 그래서 그게 다 맞는지만 보네...
		System.out.println("모두 2의 배수인가? " + result);
		System.out.println();
		
		//anyMatch
		result = Arrays.stream(intArr)
				.anyMatch(a -> a % 3 == 0);
		System.out.println("하나라도 3의 배수가 있는가? " + result);
		System.out.println();
		
		//noneMatch
		result = Arrays.stream(intArr)
				.noneMatch(a -> a % 3 == 0);
		System.out.println("3의 배수가 없는가? " + result);
	}
}
