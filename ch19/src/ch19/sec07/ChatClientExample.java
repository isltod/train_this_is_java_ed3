package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClientExample {
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;
	
	public void connect() throws IOException {
		//이게 오류없다면 이미 연결 성공
		socket = new Socket("localhost", 50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[클라이언트] 연결에 성공했습니다.");
	}
	
	public void receive() {
		Thread thread = new Thread(() -> {
			try {
				while (true) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + chatName + "@" + clientIp + "> " + message);
				}
			} catch (IOException e) {
				System.out.println("[클라이언트] 서버 연결 끊김");
				System.exit(0);
			}
		});
		thread.start();
	}

	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush();
	}
	
	public void unconnect() throws IOException {
		socket.close();
		System.out.println("[클라이언트] 연결 끊음");
	}

	public static void main(String[] args) {
		try {
			ChatClientExample chatClient = new ChatClientExample();
			chatClient.connect();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("대화명 입력: ");
			chatClient.chatName = scanner.nextLine();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json);
			
			//받는 건 별도의 스레드로 돌리고, 메인은 입력 처리하네...
			chatClient.receive();

			//메뉴 출력
			System.out.println("------------------------------------------------------------");
			System.out.println("보낼 메시지를 입력하고 엔터 키를 입력하세요.");
			System.out.println("채팅을 종료하려면 q 또는 Q를 입력하고 엔터 키를 입력하세요.");
			System.out.println("------------------------------------------------------------");
			//키보드 입력 처리
			while (true) {
				String message = scanner.nextLine();
				if (message.toLowerCase().equals("q")) {
					break;
				} else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json);
				}
			}
			scanner.close();
			//TCP 서버 종료
			chatClient.unconnect();
		} catch (IOException e) {
			System.out.println("[클라이언트] 서버 연결 안됨");
		}
	}
}
