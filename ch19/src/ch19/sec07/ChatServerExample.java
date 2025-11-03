package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Pipe.SourceChannel;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

import org.json.JSONObject;

public class ChatServerExample {
	//여기서는 필요 없지만, 앞으로 다른 메소드나 포함 클래스에서 사용하도록 클래스 필드로 선언...
	ServerSocket serverSocket;
	//10개의 스레드로 서버 병목 최소화
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());
	//필드

	public static void main(String[] args) {
		//TCP 서버 시작
		try {
			ChatServerExample chatServer = new ChatServerExample();
			chatServer.start();
			
			//메뉴 출력
			System.out.println("------------------------------------------------------------");
			System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 엔터 키를 입력하세요.");
			System.out.println("------------------------------------------------------------");
			
			
			//키보드 입력 처리
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String key = scanner.nextLine();
				if (key.toLowerCase().equals("q")) break;
			}
			scanner.close();
			//TCP 서버 종료
			chatServer.stop();
		} catch (IOException e) {
			System.out.println("[서버] " + e.getMessage());
		}
	}
	
	public void start() throws IOException {
		serverSocket = new ServerSocket(50001);
		System.out.println("[서버] 시작됨");

		// 이 스레드에서는 계속 돌면서 클라이언트 연결 처리
		Thread thread = new Thread(() -> {
			try {
				while (true) {
					System.out.println("\n[서버] 연결 요청을 기다림\n");
					//요청이 올때까지 blocking 상태 - 여기까지는 아무 클라이언트도 없었다는 얘기니까 문제 없는데...
					Socket socket = serverSocket.accept();
					//클라이언트 응접하는 소켓 클라이언트 클래스만 만들어 두고, 메시지를 보내는 등은 다른 메소드에서...
					SocketClient sc = new SocketClient(this, socket);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread.start();
	}
		
	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
	}

	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("퇴장: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
	}

	public void sendToAll(SocketClient sender, String message) {
		//보내는 메시지를 JSON 형태로
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();
		
		//메시지 발신자 이외에 다 보내기
		Collection<SocketClient> socketClients = chatRoom.values();
		for (SocketClient sc : socketClients) {
			if (sc == sender) continue;
			sc.send(json);
		}
	}
	
	public void stop() {
		//서버를 중지시키면 포트 언바인딩
		try {
			serverSocket.close();
			//스레드 풀도 다 꺼줘야 한다...
			threadPool.shutdownNow();
			//SocketClient들도 다 소켓을 가지고 있으니 닫기
			chatRoom.values().stream().forEach(sc -> sc.close());
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[서버] 종료됨");
	}
}
