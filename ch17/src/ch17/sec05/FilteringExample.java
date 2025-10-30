package ch17.sec05;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("신용권");
		list.add("감자바");
		list.add("람다식");
		list.add("신용권");
		list.add("박병렬");
		list.add("신나서");
		
		//중복 제거
		list.stream()
			.distinct()
			.forEach(n -> System.out.println(n));
			System.out.println();
			
		//신으로 시작하는 요소 필터링 - 그놈들만 남는다...
		list.stream()
		.filter(n -> n.startsWith("신"))		//String의 startsWith 자체가 신으로 시작하면 true 밷는다..
		.forEach(n -> System.out.println(n));
		System.out.println();
	}
}
