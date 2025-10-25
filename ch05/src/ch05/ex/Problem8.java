package ch05.ex;

public class Problem8 {
	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		int sum = 0;
		int count = 0;
		for (int[] arr : array) {
			for (int score : arr) {
				sum += score;
				count++;
			}
		}
		double avg = (double) sum / count;
		System.out.println("전체 합: " + sum);
		System.out.println("평균: " + avg);
	}
}
