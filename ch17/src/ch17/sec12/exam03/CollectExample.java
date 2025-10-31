package ch17.sec12.exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ch17.sec12.exam01.Student;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 92, "남"));
		list.add(new Student("김수영", 87, "여"));
		list.add(new Student("감자바", 95, "남"));
		list.add(new Student("오해영", 93, "여"));
		
		Map<String, Double> map = list.stream()
				.collect(Collectors.groupingBy(
						s -> s.getSex(),
						Collectors.averagingDouble(s -> s.getScore())
						)
				);
		System.out.println(map);
	}
}
