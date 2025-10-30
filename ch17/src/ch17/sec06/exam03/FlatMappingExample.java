package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMappingExample {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("this is java");
		list1.add("I am a best developer");
		list1.stream()
		//flatMap의 인수가 스트림을 요구하므로 그냥 split으로는 안된다..
		.flatMap(data -> Arrays.stream(data.split(" ")))
		.forEach(word -> System.out.println(word));
		
		//숫자를 다룰 때는 좀 복잡해지네...
		List<String> list2 = new ArrayList<>();
		list2.add("10, 20, 30");
		list2.add("40, 50");
		list2.stream()
		.flatMapToInt(data -> {
			String strArr[] = data.split(", ");
			int[] intArr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i]);
			}
			return Arrays.stream(intArr);
		})
		.forEach(n -> System.out.println(n));
	}
}
