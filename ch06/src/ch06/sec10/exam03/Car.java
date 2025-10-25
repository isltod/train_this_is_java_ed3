package ch06.sec10.exam03;

public class Car {
	int speed;
	void run() {
		System.out.println(speed + "으로 달립니다.");
	}
	static void simulate() {
		// 여긴 정적 블록이므로, 인스턴스 필드 speed를 사용하려면 먼저 자기를 객체로 만들고
		Car myCar = new Car();
		myCar.speed = 200;
		myCar.run();
	}
	public static void main(String[] args) {
		// main도 정적 블록이므로 정적 메소드 호출 가능
		simulate();
		// 하지만 인스턴스 변수를 직접 사용하려면 자기 객체를 만들어야...
		Car myCar = new Car();
		myCar.speed = 60;
		myCar.run();
	}
}
