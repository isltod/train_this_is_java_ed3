package ch17.sec07.exam01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 30),
				new Student("유미선", 20)
			);
		//오름차순
		list.stream()
		.sorted()
		.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		System.out.println();
		//내림차순
		list.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
	}
}
