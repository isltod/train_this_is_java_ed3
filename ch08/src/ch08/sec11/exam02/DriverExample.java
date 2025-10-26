package ch08.sec11.exam02;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		// 아예 매개변수에 다른 타입들을 넣어버린다...
		driver.drive(new Bus());
		driver.drive(new Taxi());
	}
}
