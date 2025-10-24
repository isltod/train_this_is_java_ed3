package ch04.sec03;

public class SwitchExpressionExample {
	public static void main(String[] args) {
		char grade = 'B';
		
		switch (grade) {
		case 'A', 'a' -> {
			// 이렇게 : 대신 ->를 쓰면 break 없어도 잘 작동된다. from Java 12
			System.out.println("우수 회원입니다.");
		}
		case 'B', 'b' -> {
			System.out.println("일반 회원입니다.");
		}
		default ->
			System.out.println("손님입니다.");
		}
	}
}
