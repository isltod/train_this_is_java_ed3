package ch21.sec04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadPoolExample {
	public static void main(String[] args) {
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				try {
					long sum = 0;
					for (int i = 0; i < 1000; i++) {
						sum += i;
					}
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
		
		int taskNum = 10000;
		
		//플랫폼 스레드 100개를 풀링해서 사용하는 스레드풀
		ExecutorService threadExecutor = Executors.newFixedThreadPool(100);
		work(taskNum, task, threadExecutor);
		
		//가상 스레드를 이용
		ExecutorService virtualThreadExecutor = Executors.newVirtualThreadPerTaskExecutor();
		work(taskNum, task, virtualThreadExecutor);
	}

	private static void work(int taskNum, Runnable task, ExecutorService threadExecutor) {
		// TODO Auto-generated method stub
		long start = System.nanoTime();
		try {
			for (int i = 0; i < taskNum; i++) {
				threadExecutor.execute(task);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//shutdown은 작업 끝날때까지 기다린다...멈춘다가 아니다...그래서 1시간 기다린다..
		threadExecutor.shutdown();
		try {
			threadExecutor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		long workTime = end - start;
		System.out.println("작업 처리 시간: " + workTime + " ns");
	}
}
