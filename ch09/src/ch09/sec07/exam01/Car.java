package ch09.sec07.exam01;

public class Car {
	private Tire tire1 = new Tire();
	// 위는 일반적인데, 여기서 굳이 코드 뒤에 더덕더덕 붙여서 익명 개체를 만든다..
	private Tire tire2 = new Tire() {
		@Override
		public void roll() {
			System.out.println("익명 자식 Tire 객체 1dl 굴러갑니다.");
		}
	};
	
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	
	// 이번에는 메소드 내의 로컬 변수에서...
	public void run2() {
		Tire tire = new Tire() {
			@Override
			public void roll() {
				System.out.println("익명 자식 Tire 객체 2dl 굴러갑니다.");
			}
		};
		tire.roll();
	}
	
	// 마지막은 메소드 매개변수에 넣어주기
	public void run3(Tire tire) {
		tire.roll();
	}
}
