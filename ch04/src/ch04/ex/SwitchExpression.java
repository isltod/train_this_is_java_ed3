package ch04.ex;

import java.util.Scanner;

public class SwitchExpression {
	public static void main(String[] args) {
		// 문제 2.
		String grade = "B";
		
		int score2 = switch (grade) {
		case "A" -> 100;
		case "B" -> 100 - 20;
		default -> 60;
		};
		System.out.println(score2);
		
		// 문제 3.
		System.out.println("문제 3---------------------");
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		// 문제 4
		System.out.println("문제 4---------------------");
		while (true) {
			int dice1 = (int)(Math.random() * 6 + 1);
			int dice2 = (int)(Math.random() * 6 + 1);
			System.out.println("(" + dice1 + ", " + dice2 + ")");
			if (dice1 + dice2 == 5) {
				break;
			}
		}
		
		// 문제 5.
		System.out.println("문제 5---------------------");
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}

		// 문제 6.
		System.out.println("문제 6---------------------");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		// 문제 7
		System.out.println("문제 7---------------------");
		Scanner scanner = new Scanner(System.in);
		int balance = 0;
		Loop: while (true) {
			String menu = """
					---------------------------------
					1.예금 | 2.출금 | 3.잔고 | 4.종료
					---------------------------------
					""";
			System.out.print(menu);
			System.out.print("선택> ");
			String numStr = scanner.nextLine();
			switch (numStr) {
			case "1" -> {
				System.out.print("예금액> ");
				balance += Integer.parseInt(scanner.nextLine());
			}
			case "2" -> {
				System.out.print("출금액> ");
				balance -= Integer.parseInt(scanner.nextLine());
			}
			case "3" -> {
				System.out.println("잔고> " + balance);
			}
			case "4" -> {
				System.out.println("프로그램 종료");
				break Loop;
			}
			default -> System.out.println("잘못된 선택");
			}
		}
	}
}
