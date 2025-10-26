package ch07.sec08.exam02;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.drive(new Vehicle());
		
		// 매개변수를 다른 타입으로 바꿔주면 다형성
		driver.drive(new Bus());
		driver.drive(new Taxi());
	}
}
