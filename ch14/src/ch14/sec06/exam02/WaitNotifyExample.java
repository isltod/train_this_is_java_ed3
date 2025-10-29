package ch14.sec06.exam02;

public class WaitNotifyExample {
	public static void main(String[] args) {
		WorkObj workObj = new WorkObj();
		ThreadA threadA = new ThreadA(workObj);
		ThreadB threadB = new ThreadB(workObj);
		
		threadA.start();
		threadB.start();
	}
}
