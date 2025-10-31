package ch17.sec13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParallelExample {
	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < 100000000; i++) {
			//101 미만 즉 100점 아래 점수
			scores.add(random.nextInt(101));
		}
		
		double avg = 0.0;
		long startTime = 0;
		long endTime = 0;
		long time = 0;
		
		startTime = System.nanoTime();
		double sum = 0;
		for (int score : scores) {
			sum += score;
		}
		avg = (double) sum / scores.size();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("avg: " + avg + ", 컬렉션 for문 처리시간: " + time + " ns");

		Stream<Integer> stream = scores.stream();
		startTime = System.nanoTime();
		avg = stream
				.mapToInt(i -> i.intValue())
				.average()
				.getAsDouble();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + " ns");

		startTime = System.nanoTime();
		Stream<Integer> parallelStream = scores.parallelStream();
		avg = parallelStream
				.mapToInt(i -> i.intValue())
				.average()
				.getAsDouble();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("avg: " + avg + ", 병렬 스트림 처리 시간: " + time + " ns");
}
}
