package ch17.sec07.exam02;

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
		.sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
		.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		System.out.println();
		//내림차순 - 단순히 같은 메소드 호출에 매개변수 순서만 바꾸면 반대차순이 된다..
		list.stream()
		.sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
		.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
	}
}
