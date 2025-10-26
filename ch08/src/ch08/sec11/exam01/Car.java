package ch08.sec11.exam01;

public class Car {
	// 실제 구현 개체를 인터페이스 형식으로 만들고
	Tire tire1 = new HankookTire();
	Tire tire2 = new HankookTire();
	
	void run() {
		// 요게 인터페이스의 추상 메소드를 호출 -> 실제로는 구현 개체의 메소드 실행
		tire1.roll();
		tire2.roll();
	}
}
