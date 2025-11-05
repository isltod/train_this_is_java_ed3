package ch21.sec05;

public class VirtualThreadExample {
	public static void main(String[] args) {
		Thread.startVirtualThread(() -> {
			System.out.println("virtualThread1 실행");
		});
		
		Thread.ofVirtual().start(() -> {
			System.out.println("virtualThread2 실행");
		});

		Thread virtualThread3 = Thread.ofVirtual().name("downLoadThread").start(() -> {
			System.out.println("virtualThread3 실행");
		});
		System.out.println("virtualThread3 이름: " + virtualThread3.getName());
	}
}
