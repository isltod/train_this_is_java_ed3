package ch19.ex.problem7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductClient {
	private static Scanner scanner = new Scanner(System.in);
	private static Socket socket;
	private static DataInputStream dis;
	private static DataOutputStream dos;
	
	public static void main(String[] args) {
		try {
			socket = new Socket("localhost", 50001);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("[클라이언트] 서버에 연결됨");
			list();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void list() throws IOException {
		// TODO Auto-generated method stub
		//타이틀 및 컬럼명 출력
		System.out.println();
		System.out.println("[상품 목록]");
		System.out.println("---------------------------------------------------------------");
		System.out.printf("%-6s%-30s%-15s%-10s\n", "no", "name", "price", "stock");
		System.out.println("---------------------------------------------------------------");
		//TODO: 여기 상품 목록 서버에서 받아서 뿌리는 코드가 필요하네... 
		JSONObject request = new JSONObject();
		request.put("menu", 0);
		//꼭 빈 json을 data에 넣는데, 이걸 왜하지? 그냥 일관성 문제인가?
		request.put("data", new JSONObject());
		dos.writeUTF(request.toString());
		dos.flush();
		JSONObject response = new JSONObject(dis.readUTF());
		JSONArray data = response.getJSONArray("data");
		for (int i = 0; i < data.length(); i++) {
			JSONObject product = data.getJSONObject(i);
			System.out.printf("%-6s%-30s%-15s%-10s\n", 
					product.getInt("no"), product.getString("name"), product.getInt("price"), product.getInt("stock"));
		}
		//메뉴 출력
		menu();
	}

	private static void menu() throws IOException {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println("메뉴: 1.Create | 2.Update | 3.Delete | 4.Exit");
		System.out.print("선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		switch(menuNo) {
		case "1" -> create();
		case "2" -> update();
		case "3" -> delete();
		case "4" -> exit();
	}
}

	private static void exit() {
		try {
			socket.close();
			scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[클라이언트] 종료 됨");
	}

	private static void delete() throws IOException {
		//상품 삭제 내용 입력
		System.out.println("[상품 삭제]");
		System.out.print("상품 번호: ");
		int no = Integer.parseInt(scanner.nextLine());
		//삭제할 제품 data
		JSONObject data = new JSONObject();
		data.put("no", no);
		//메뉴 입혀서 발송
		JSONObject request = new JSONObject();
		request.put("menu", 3);
		request.put("data", data);
		dos.writeUTF(request.toString());
		dos.flush();
		//응답 받는건 왜 할까? 지금은 실패 코드도 없는데...나중을 위해서?
		JSONObject response = new JSONObject(dis.readUTF());
		if (response.getString("status"). equals("success")) {
			//이게 없는데...지금은 어쨌든 메뉴로 돌아가야하는데...
		}
		list();
	}

	private static void update() throws IOException {
		//상품 수정 내용 입력
		System.out.println("[상품 수정]");
		Product product = new Product();
		System.out.print("상품 번호: ");
		product.setNo(Integer.parseInt(scanner.nextLine()));
		System.out.print("이름 변경: ");
		product.setName(scanner.nextLine());
		System.out.print("가격 변경: ");
		product.setPrice(Integer.parseInt(scanner.nextLine()));
		System.out.print("재고 변경: ");
		product.setStock(Integer.parseInt(scanner.nextLine()));
		//수정할 제품 data
		JSONObject data = new JSONObject();
		data.put("no", product.getNo());
		data.put("name", product.getName());
		data.put("price", product.getPrice());
		data.put("stock", product.getStock());
		//메뉴 입혀서 발송
		JSONObject request = new JSONObject();
		request.put("menu", 2);
		request.put("data", data);
		dos.writeUTF(request.toString());
		dos.flush();
		//응답 받는건 왜 할까? 지금은 실패 코드도 없는데...나중을 위해서?
		JSONObject response = new JSONObject(dis.readUTF());
		if (response.getString("status"). equals("success")) {
			//이게 없는데...지금은 어쨌든 메뉴로 돌아가야하는데...
		}
		list();
	}

	private static void create() throws IOException {
		//상품 정보 입력
		System.out.println("[상품 생성]");
		Product product = new Product();
		System.out.print("상품 이름: ");
		product.setName(scanner.nextLine());
		System.out.print("상품 가격: ");
		product.setPrice(Integer.parseInt(scanner.nextLine()));
		System.out.print("상품 재고: ");
		product.setStock(Integer.parseInt(scanner.nextLine()));
		//상품을 일단 만들어야 목록 검색이 된다...menu - 1, data - product
		JSONObject data = new JSONObject();
		data.put("name", product.getName());
		data.put("price", product.getPrice());
		data.put("stock", product.getStock());
		JSONObject request = new JSONObject();
		request.put("menu", 1);
		request.put("data", data);
		//생성하라고 요청
		dos.writeUTF(request.toString());
		dos.flush();
		//결과를 받으라는데...
		JSONObject response = new JSONObject(dis.readUTF());
		if (response.getString("status").equals("success")) {
			//근데 어차피 돌아가야 하는데, 이걸 왜 검사하지?
		}
		//다시 상품 목록으로 되돌아간다
		list();
	}
}