package ch19.sec04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class NewsServerExample {
	//여기서는 필요 없지만, 앞으로 다른 메소드나 포함 클래스에서 사용하도록 클래스 필드로 선언...
	private static DatagramSocket datagramSocket = null;
	public static void main(String[] args) {
		//메뉴 출력
		System.out.println("------------------------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 엔터 키를 입력하세요.");
		System.out.println("------------------------------------------------------------");
		
		//UDP 서버 시작
		startServer();
		
		//키보드 입력 처리
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) break;
		}
		scanner.close();
		
		//UDP 서버 종료
		stopServer();
	}
	
	private static void startServer() {
		// 이 스레드에서는 계속 돌면서 클라이언트 연결 처리
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					datagramSocket = new DatagramSocket(50001);
					System.out.println("[서버] 시작됨");
					//계속 돌면서
					while (true) {
						//UDP는 연결 요청/수락 등은 없고, 막바로 구독 요청 뉴스 주제 얻기
						DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
						datagramSocket.receive(receivePacket);
						String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
						
						//클라이언트 정보 - 근데 이건 IP 어떻게 얻지?
						SocketAddress socketAddress = receivePacket.getSocketAddress();
						
						//10개의 뉴스를 클라이언트로 전송
						for (int i = 1; i <= 10; i++) {
							String data = newsKind + ": 뉴스 " + i;
							byte[] bytes = data.getBytes("UTF-8");
							DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
							datagramSocket.send(sendPacket);
						}
						System.out.println("[서버] 뉴스 데이터를 보냄");
						
						//연결 끊기 - 별도의 소켓을 만들지 않으므로 여기서는 끊을게 없음
					}
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		thread.start();
	}
	
	private static void stopServer() {
		//심지어 소켓을 끊는데 예외 처리도 필요 없ㅇ.ㅁ
		datagramSocket.close();
		System.out.println("[서버] 종료됨");
	}
}
