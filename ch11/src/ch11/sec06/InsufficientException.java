package ch11.sec06;

public class InsufficientException extends Exception {
	public InsufficientException() {
		// TODO Auto-generated constructor stub
	}
	public InsufficientException(String message) {
		// 요렇게만 하면 예외 개체의 메시지로 들어가는 듯...
		super(message);
	}
}
