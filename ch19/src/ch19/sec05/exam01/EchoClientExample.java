package ch19.sec05.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClientExample {
	public static void main(String[] args) {
		try {
			//이게 오류없다면 이미 연결 성공
			Socket socket = new Socket("localhost", 50001);
			System.out.println("[클라이언트] 연결에 성공했습니다.");
			
			//데이터 보내기
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String message = "나는 자바가 좋아~~~";
			dos.writeUTF(message);
			dos.flush();
			System.out.println("[클라이언트] 데이터 보냄: " + message);
			
			//보냈던 데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String recieveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음: " + recieveMessage);
			
			//소켓 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
