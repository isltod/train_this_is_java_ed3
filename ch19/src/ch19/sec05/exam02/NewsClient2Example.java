package ch19.sec05.exam02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewsClient2Example {
	public static void main(String[] args) {
		try {
			//UDP는 연결 없이 막바로 보냄
			DatagramSocket datagramSocket = new DatagramSocket();
		
			//구독하고픈 뉴스 주제 보내기
			String data = "스포츠";
			byte[] bytes = data.getBytes("UTF-8");
			DatagramPacket senPacket = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 50001));
			datagramSocket.send(senPacket);
			System.out.println("[클라이언트] 데이터 보냄: " + data);
			
			//뉴스 데이터 받기
			DatagramPacket recievePacket = new DatagramPacket(new byte[1024], 1024);
			while (true) {
				datagramSocket.receive(recievePacket);
				String news = new String(recievePacket.getData(), 0, recievePacket.getLength(), "UTF-8");
				System.out.println(news);
				
				if (news.contains("뉴스 100")) break;
			}
			System.out.println("[클라이언트] 데이터 받음: ");
			
			//소켓 닫기
			datagramSocket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
