package ch05.ex;

import java.util.Scanner;

public class Problem9 {
	public static void main(String[] args) {
		String menu = """
				------------------------------------------------------
				1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
				------------------------------------------------------
				""";
		Scanner scanner = new Scanner(System.in);
		System.out.println(menu);
		System.out.print("선택> ");
		String str = scanner.nextLine();
		System.out.print("학생수> ");
		int numStudents = Integer.parseInt(scanner.nextLine());
		int[] scores = new int[numStudents];
		
		System.out.println(menu);
		System.out.print("선택> ");
		str = scanner.nextLine();
		int maxScore = 0;
		int sum = 0;
		int i = 0;
		while (i < numStudents) {
			System.out.print("scores[" + i + "]> ");
			scores[i] = Integer.parseInt(scanner.nextLine());
			if (maxScore < scores[i]) maxScore = scores[i];
			sum += scores[i];
			i++;
		}
		double avg = (double) sum / numStudents;
		
		Loop: while (true) {
			System.out.println(menu);
			System.out.print("선택> ");
			switch (scanner.nextLine()) {
				case "3" -> {
					for (int i1 = 0; i1 < scores.length; i1++) {
						System.out.println("scores[" + i1 + "]: " + scores[i1]);
					}
				}
				case "4" -> {
					System.out.println("최고 점수: " + maxScore);
					System.out.println("평균 점수: " + avg);
				}
				case "5" -> {
					break Loop;
				}
			}
		}
		System.out.println("프로그램 종료");
	}
}
