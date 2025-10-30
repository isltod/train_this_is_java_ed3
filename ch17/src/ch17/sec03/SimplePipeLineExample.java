package ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimplePipeLineExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
					new Student("홍길동", 10),
					new Student("신용권", 30),
					new Student("유미선", 20)
				);
		
		//한 단계씩 따로 만들기
		Stream<Student> studentStream = list.stream();
		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
		double avg = scoreStream.average().getAsDouble();
		System.out.println("평균 점수: " + avg);
		
		//한번에 쭉 만들기
		double average = list.stream()
				.mapToInt(student -> student.getScore())
				.average()
				.getAsDouble();
		System.out.println("평균 점수: " + average);
	}
}
