package ch11.sec06;

public class Account {
	private long balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws InsufficientException {
		if (balance < money) {
			// 위에 throws InsufficientException 없이 아래 코드를 입력했더니 빨간줄 떠서 오류 넣으란다...이런게 Exception 정의 효과...
			throw new InsufficientException("잔고부족: " + (money-balance) + " 모자람");
			// 예외 발생하면 여기서 실행 끝...아래는 안 내려간다..
		}
		balance -= money;
	}
}
