package ch05.sec06;

import java.util.Iterator;

import ch05.sec01.newArrayTest;

public class ArrayCreateByValueListExample {
	public static void main(String[] args) {
		int[] scores;
		scores = new int[] {83, 90, 87};
		int sum1 = 0;
		for (int i = 0; i < scores.length; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합: " + sum1);
		
		printItem(new int[] {83,87,90});
	}
	public static void printItem(int[] scores) {
		for (int i = 0; i < scores.length; i++) {
			System.out.println("점수[" + i + "]: " + scores[i]);
		}
	}
}
