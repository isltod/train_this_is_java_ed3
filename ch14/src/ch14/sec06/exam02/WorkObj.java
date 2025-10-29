package ch14.sec06.exam02;

public class WorkObj {
	//synchronized 해놓는게 키인듯...이걸로 다음 쓸 사람 깨우기가 가능...
	public synchronized void methodA() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodA 실행");
		//자기가 먼저 잠들면 끝장이므로 일단 먼저 깨우고
		notify();
		//그러고 나서 잠든다
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void methodB() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodB 실행");
		//자기가 먼저 잠들면 끝장이므로 일단 먼저 깨우고
		notify();
		//그러고 나서 잠든다
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
