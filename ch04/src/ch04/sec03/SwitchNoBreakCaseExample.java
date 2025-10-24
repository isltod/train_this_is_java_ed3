package ch04.sec03;

public class SwitchNoBreakCaseExample {
	public static void main(String[] args) {
		int time = (int)(Math.random()*4) + 8;
		System.out.println("[현재 시간 : " + time + "시]");
		
		switch (time) {
		case 8:
			System.out.println("출근합니다.");
			// break가 없으면 조건이 맞든 안맞든 아래를 다 실행해버린다...중괄호로 묶어도 마찬가지...
		case 9:
			System.out.println("회의를 합니다.");
		case 10:
			System.out.println("업무를 봅니다.");
		default:
			System.out.println("외근을 나갑니다.");
		}
	}
}
