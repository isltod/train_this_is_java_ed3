package ch14.sec09.exam02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {
	public static void main(String[] args) {
		//1000개의 메일 생성
		String[][] mails = new String[1000][3];
		for (int i = 0; i < 1000; i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member" + i + "@my.com";
			mails[i][2] = "신상품 입고";
		}
		
		//이렇게 스레드풀 만들고
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 1000; i++) {
			//여기서는 아래 익명 객체에서 i를 수정하지 않으므로 상관 없지만...
			//로컬 nested 클래스에서는 외부 변수가 final 속성을 가지게 된다는 것을 강조한 듯...
			final int idx = i;
			//이렇게 풀에 작업을 넣고
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					Thread thread = Thread.currentThread();
					String from = mails[idx][0];
					String to = mails[idx][1];
					String content = mails[idx][2];
					System.out.println("[" + thread.getName() + "] " + from + " ==> " + to + ": " + content);
				}
			});
			//스레드 풀 종료 - 이거 예외 발생되는데 어떻게 처리해야할지...
//			executorService.shutdown();
		}
	}
}
