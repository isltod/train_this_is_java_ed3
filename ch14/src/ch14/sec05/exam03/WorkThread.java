package ch14.sec05.exam03;

public class WorkThread extends Thread {
	public boolean work = true;
	public WorkThread(String name) {
		// TODO Auto-generated constructor stub
		setName(name);
	}
	@Override
	public void run() {
		while (true) {
			if (work) {
				System.out.println(getName() + " 작업처리");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				//근데 누구한테 양보한다는 거냐?
				Thread.yield();
			}
		}
	}
}
