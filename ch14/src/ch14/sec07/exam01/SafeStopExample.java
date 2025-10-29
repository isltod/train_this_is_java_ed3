package ch14.sec07.exam01;

public class SafeStopExample {
	public static void main(String[] args) {
		PrintThread printThread = new PrintThread();
		printThread.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//뭔가 종료가 되긴 하는데 시간보다 훨씬 더 걸리고, 그동안 이클립스는 먹통되고...이거 맞나?
		printThread.setStop(true);
	}
}
