package ch19.sec03.exam01;

import java.io.IOException;
import java.net.Socket;

public class ClientExample {
	public static void main(String[] args) {
		try {
			//이게 오류없다면 이미 연결 성공
			Socket socket = new Socket("localhost", 50001);
			System.out.println("[클라이언트] 연결에 성공했습니다.");
			
			//바로 소켓 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
