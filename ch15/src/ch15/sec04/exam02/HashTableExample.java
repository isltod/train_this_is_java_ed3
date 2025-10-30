package ch15.sec04.exam02;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import ch15.sec02.exam01.Board;

public class HashTableExample {
	public static void main(String[] args) {
		//스레드 동기화 때문에 Hashtable은 되지만 HashMap은 안된다...
//		Map<String, Integer> map = new Hashtable<>();
		Map<String, Integer> map = new HashMap<>();
		
		//작업1 스레드
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					map.put(String.valueOf(i), i);
				}
			}
		};
		//작업2 스레드
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					map.put(String.valueOf(i), i);
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
		System.out.println("총 엔트리 수:" + size);
	}
}
