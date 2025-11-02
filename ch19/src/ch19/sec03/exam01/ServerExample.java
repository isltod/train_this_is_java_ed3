package ch19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	//여기서는 필요 없지만, 앞으로 다른 메소드나 포함 클래스에서 사용하도록 클래스 필드로 선언...
	private static ServerSocket serverSocket = null;
	public static void main(String[] args) {
		//메뉴 출력
		System.out.println("------------------------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 엔터 키를 입력하세요.");
		System.out.println("------------------------------------------------------------");
		
		//TCP 서버 시작
		startServer();
		
		//키보드 입력 처리
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) break;
		}
		scanner.close();
		
		//TCP 서버 종료
		stopServer();
	}
	
	private static void stopServer() {
		//서버를 중지시키면 포트 언바인딩
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[서버] 종료됨");
	}
	
	private static void startServer() {
		// 이 스레드에서는 계속 돌면서 클라이언트 연결 처리
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					//계속 돌면서
					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						//요청이 올때까지 blocking 상태
						Socket socket = serverSocket.accept();
						
						//여기 넘어왔다는 건 연결 요청 들어왔다는 의미, 클라이언트 정보
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버] " + isa.getHostString() + "의 연결 요청을 수락함");
						
						//바로 연결 끊기
						System.out.println("[서버] " + isa.getHostString() + "의 연결을 끊음");
						socket.close();
					}
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		thread.start();
	}
}
