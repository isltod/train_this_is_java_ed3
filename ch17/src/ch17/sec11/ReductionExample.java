package ch17.sec11;

import java.sql.Struct;
import java.util.Arrays;
import java.util.List;

import ch17.sec07.exam02.Student;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 30),
				new Student("유미선", 20)
			);
		//원래 하던 방식
		int sum = list.stream()
				.mapToInt(Student :: getScore)
				.sum();
		
		//커스텀 reduce
		int sum2 = list.stream()
				.mapToInt(Student :: getScore)
				.reduce(0, (a, b) -> a + b);
		
		System.out.println("sum1: " + sum);
		System.out.println("sum2: " + sum2);
	}
}
