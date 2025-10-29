package ch14.sec05.exam02;

public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		//그러니까 이 사이에 할 일들을 해놔야 한다...
		try {
			//이 이후로는 사실상 스레드를 나눈 의미가 없어진다...
			sumThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1~100 합: " + sumThread.getSum());
	}
}
