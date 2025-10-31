package ch17.sec10;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
//		//그냥 값을 부르면 오류나는 코드
//		double avg = list.stream()
//				.mapToInt(Integer :: intValue)
//				.average()
//				.getAsDouble();
		
		//오류를 피하려면
		//방법1 - Optional을 먼저 만들고, isPresent 부르기
		OptionalDouble optional = list.stream()
				.mapToInt(Integer :: intValue)
				.average();
		if (optional.isPresent()) {
			System.out.println("방법1 평균: " + optional.getAsDouble());
		} else {
			System.out.println("방법1 평균: " + -0.0);
		}
		
		//방법2 - orElse로 실패 값 주기
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(-0.0);
		System.out.println("방법2 평균: " + avg);
		
		//방법3 - 막판에 ifPresent로 조건 처리 넣기
		list.stream()
		.mapToInt(Integer :: intValue)
		.average()
		.ifPresent(n -> System.out.println("방법3 평균: " + n));
	}
}
