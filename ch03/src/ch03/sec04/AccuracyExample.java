package ch03.sec04;

public class AccuracyExample {
	public static void main(String[] args) {
		System.out.println("실수로 나누기 계산 - 부정확");
		int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		double result_i = apple - number * pieceUnit;
		System.out.println("사과 1개에서 남은 양: " + result_i);
		System.out.println("정수로 나누기 계산 - 정확");
		int totalPieces = (int) (apple / pieceUnit);
		int result_f = totalPieces - number;
		System.out.println("사과 1개에서 남은 양: " + result_f);
	}
}
