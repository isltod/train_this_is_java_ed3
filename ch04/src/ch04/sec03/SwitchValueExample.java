package ch04.sec03;

public class SwitchValueExample {
	public static void main(String[] args) {
		String grade = "B";
		// Switch 문으로 바로 변수값 할당
		int score = switch (grade) {
		case "A" -> 100;
		case "B" -> {
			int result = 100 - 20;
			yield result;	// 중괄호 묶은 문에서는 반드시 yield 사용
		}
		default -> 60;
		};	// 예전 Switch 문에는 ; 가 없는데, 바로 변수에 값을 대입하므로 이제는 ; 가 있다...
		System.out.println("score: " + score);
	}
}
