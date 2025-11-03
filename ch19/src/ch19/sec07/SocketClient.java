package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	ChatServerExample chatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String clientIp;
	String chatName;

	public SocketClient(ChatServerExample chatServerExample, Socket socket) {
		this.chatServer = chatServerExample;
		this.socket = socket;
		try {
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostString();
			//이 클래스 생기면서 계속 대기하면서 메시지 받기
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void receive() {
		chatServer.threadPool.execute(() -> {
			try {
				while (true) {
					//받기를 기다린다...여기서 블로킹되지만, 클라이언트마다 하나씩이니까...
					String receiveJson = dis.readUTF();
					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");
					switch (command) {
					case "incoming":
						this.chatName = jsonObject.getString("data");
						chatServer.sendToAll(this, "입장하셨습니다.");
						chatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						break;
					}
				}
			} catch (IOException e) {
				chatServer.sendToAll(this, "퇴장하셨습니다.");
				chatServer.removeSocketClient(this);
			}
		}); 
	}
					
	public void send(String message) {
		try {
			dos.writeUTF(message);
			dos.flush();
			//메시지를 계속 보내야 하니 여기서 닫으면 않된다...
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
