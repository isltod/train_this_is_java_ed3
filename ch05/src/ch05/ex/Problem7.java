package ch05.ex;

public class Problem7 {
	public static void main(String[] args) {
		int[] array = {1, 5, 3, 8, 2};
		int maxNum = 0;
		for (int num : array) {
			if (maxNum < num) {
				maxNum = num;
			}
		}
		System.out.println("최대값: " + maxNum);
	}
}
