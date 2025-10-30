package ch15.sec07;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ch15.sec02.exam01.Board;

public class SyncronizedMapExample {
	public static void main(String[] args) {
		//원래는 동기화 안된 HashMap을 동기화해서 사용
		Map<Integer, String> map = new HashMap<>();
//		Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
		
		//작업1 스레드
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					map.put(i, "내용" + i);
				}
			}
		};
		//작업2 스레드
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					map.put(i, "내용" + i);
				}
			}
		};
		threadA.start();
		threadB.start();
		
		//스레드 종료 기다리고 결과
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size = map.size();
		System.out.println("총 객체 수:" + size);
	}
}
