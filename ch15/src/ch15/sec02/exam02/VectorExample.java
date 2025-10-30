package ch15.sec02.exam02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import ch15.sec02.exam01.Board;

public class VectorExample {
	public static void main(String[] args) {
		//스레드 동기화 때문에 Vector는 되지만 ArrayList는 안된다...
		List<Board> list = new Vector<>();
//		List<Board> list = new ArrayList();
		
		//작업1 스레드
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					list.add(new Board("제목" + 1, "내용" + i,  "글쓴이" + i));
				}
			}
		};
		//작업2 스레드
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					list.add(new Board("제목" + 1, "내용" + i,  "글쓴이" + i));
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
		int size = list.size();
		System.out.println("총 객체 수:" + size);
	}
}
