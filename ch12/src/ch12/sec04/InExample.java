package ch12.sec04;

import java.io.IOException;

public class InExample {
	public static void main(String[] args) {
		int speed = 0;
		int keyCode = 0;
		
		while (true) {
			if (keyCode != 13 && keyCode != 10) {
				if (keyCode == 49) {			//숫자 1
					speed++;
				} else if (keyCode == 50) {		//숫자 2
					speed--;
				} else if (keyCode == 51) {		//숫자 3
					break;
				} //나머지 키는 건너뛰고
				System.out.println("------------------------");
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("------------------------");
				System.out.println("현재속도 =" + speed);
				System.out.println("선택: ");
			}
			try {
				keyCode = System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}
}
