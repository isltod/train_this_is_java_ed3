package ch14.sec06.exam1;

public class User1Thread extends Thread {
	private Calculator calculator;
	
	public User1Thread() {
		setName("User1Therad");
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory1(100);
	}
}
