package ch14.sec06.exam1;

public class User2Thread extends Thread {
	private Calculator calculator;
	
	public User2Thread() {
		setName("User2Therad");
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory2(50);
	}
}
