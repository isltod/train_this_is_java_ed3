package ch06.ex;

public class Account {
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	private int balance;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		if (balance > MAX_BALANCE) {
			this.balance = MAX_BALANCE;
		} else if (balance < MIN_BALANCE) {
			this.balance = MIN_BALANCE;
		} else {
			this.balance = balance;
		}
	}
}
