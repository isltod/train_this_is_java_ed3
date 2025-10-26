package ch08.sec11.exam01;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		// 일단 바로 실행하면 구현 개체의 초기 설정값대로...
		myCar.run();
		
		// 바꿔 끼우고 실행하면...
		myCar.tire1 = new KumhoTire();
		myCar.run();
	}
}
