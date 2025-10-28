package ch12.sec07;

import java.util.Iterator;
import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {
		// 시드가 같으면 같은 난수가 나오는지 보자...
		int[] randomNumber = new int[10];
		Random random = new Random(3);
		for (int i = 0; i < randomNumber.length; i++) {
			randomNumber[i] = random.nextInt(45) + 1;	// 로또 번호같은 숫자 만들기
			System.out.print(randomNumber[i] + " ");
		}
		System.out.println();
		random = new Random(3);
		for (int i = 0; i < randomNumber.length; i++) {
			randomNumber[i] = random.nextInt(45) + 1;	// 로또 번호같은 숫자 만들기
			System.out.print(randomNumber[i] + " ");
		}
		System.out.println();
	}
}
