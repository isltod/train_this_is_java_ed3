package ch14.sec09.exam03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSubmitExample {
	public static void main(String[] args) {
		//1. 스레드풀 만들고
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i <= 100; i++) {
			final int idx = i;
			//2. 작업 객체 만들어 큐에 넣기
			Future<Integer> future = executorService.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int i = 0; i <= idx; i++) {
						sum += i;
					}
					Thread thread = Thread.currentThread();
					System.out.println("[" + thread.getName() + "] 1~" + idx + " 합 계산");
					return sum;
				}
			});
			//3. 결과값 받아서 처리
			int result;
			try {
				result = future.get();
				System.out.println("\t리턴값: " + result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("메인 스레드 종료");
		executorService.shutdown();
	}
}
