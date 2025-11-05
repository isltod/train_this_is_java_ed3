package ch21.sec05;

public class PlatformThreadExample {
	public static void main(String[] args) {
		//기존 방식
		Thread platformThread1 = new Thread(() -> {
			System.out.println("platformThread1 실행");
		});
		platformThread1.start();
		
		//자바21
		Thread.ofPlatform().start(() -> {
			System.out.println("platformThread2 실행");
		});
		
		Thread.ofPlatform().name("copyThread").start(() -> {
			System.out.println("platformThread3 실행");
		});
		
		Thread platformThread = Thread.ofPlatform().name("downloadThread").daemon().start(() -> {
			System.out.println("platformThread4 실행");
		});
		System.out.println("platformThread4 이름: " + platformThread.getName());
	}
}
