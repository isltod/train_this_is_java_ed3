package ch11.sec06;

public class AccountExample {
	public static void main(String[] args) {
		Account account = new Account();
		//예금
		account.deposit(10000);
		System.out.println("예금액: " + account.getBalance());
		//출금 - try-catch 없이 account.withdraw(30000)만 넣으면 빨간줄 간다...
		try {
			account.withdraw(30000);
		} catch (InsufficientException e) {
			// TODO Auto-generated catch block
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}
