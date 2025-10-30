package ch16.ex.problem4;

public class Example {
	public static void main(String[] args) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("작업 스레드가 실행됩니다.");
				System.out.println("작업 스레드가 실행됩니다.");
				System.out.println("작업 스레드가 실행됩니다.");
			}
		};
		thread.start();
	}
}
