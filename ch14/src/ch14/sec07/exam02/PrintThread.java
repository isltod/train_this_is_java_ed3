package ch14.sec07.exam02;

public class PrintThread extends Thread {
	private boolean stop;

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	//스레드의 run은 다른 메소드랑 틀리게 start 하면 알아서 돌아가고, 그 동안 다른 메소드를 실행하기도하고..
	@Override
	public void run() {
		try {
			while (!stop) {
				System.out.println("실행중");
					Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}
