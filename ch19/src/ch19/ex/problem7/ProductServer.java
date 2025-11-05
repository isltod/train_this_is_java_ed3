package ch19.ex.problem7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONObject;

import ch19.sec07.ex.SocketClient;
import netscape.javascript.JSObject;

public class ProductServer {
	private ServerSocket serverSocket;
	private ExecutorService threadPool;
	private List<Product> products;
	private int sequence;
	
	public static void main(String[] args) {
		ProductServer productServer = new ProductServer();
		try {
			productServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			productServer.stop();
		}
	}

	private void stop() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		threadPool.shutdown();
		threadPool.shutdownNow();
		System.out.println("[서버] 종료됨");
	}

	private void start() throws IOException {
		// TODO Auto-generated method stub
		serverSocket = new ServerSocket(50001);
		threadPool = Executors.newFixedThreadPool(100);
		//스레드 환경에서 리스트를 관리해야 하므로 Vector
		products = new Vector<>();
		System.out.println("[서버] 시작됨");
		
		while (true) {
			Socket socket = serverSocket.accept();
			//소켓 클라이언트는 만들자마자 클라이언트 요청 기다리는 모드로...
			SocketClient sc = new SocketClient(socket);
		}
	}
	
	public class SocketClient {
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		public SocketClient(Socket socket) {
			this.socket = socket;
			try {
				this.dis = new DataInputStream(socket.getInputStream());
				this.dos = new DataOutputStream(socket.getOutputStream());
				receive();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				close();
			}
		}

		private void receive() {
			threadPool.execute(() -> {
				try {
					while (true) {
						//기다렸다 읽어서
						String receiveJson = dis.readUTF();
						//클라이언트 요청 종류는 json 객체로 만들어 읽고,
						JSONObject request = new JSONObject(receiveJson);
						int menu = request.getInt("menu");
						
						//종류에 맞춰서 나머지 처리
						switch (menu) {
						case 0 -> list(request);
						case 1 -> create(request);
						case 2 -> update(request);
						case 3 -> delete(request);
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					close();
				}
			});
		}

		private void list(JSONObject request) throws IOException {
			JSONArray data = new JSONArray();
			for (Product product : products) {
				JSONObject p = new JSONObject();
				p.put("no", product.getNo());
				p.put("name", product.getName());
				p.put("price", product.getPrice());
				p.put("stock", product.getStock());
				data.put(p);
			}
			JSONObject response = new JSONObject();
			response.put("status", "success");
			response.put("data", data);
			dos.writeUTF(response.toString());
			dos.flush();
		}

		private void create(JSONObject request) throws IOException {
			JSONObject data = request.getJSONObject("data");
			Product product = new Product();
			product.setNo(++sequence);
			product.setName(data.getString("name"));
			product.setPrice(data.getInt("price"));
			product.setStock(data.getInt("stock"));
			products.add(product);
			//일단 결과를 클라이언트에 대답한다...오류나면 실패 메시지를 보내야 하는데...
			JSONObject response = new JSONObject();
			response.put("status", "success");
			//빈 데이터를 왜 넣지? 차라리 상품 목록을 보내야 하지 않나?
			response.put("data", new JSONObject());
			dos.writeUTF(response.toString());
			dos.flush();
		}

		private void update(JSONObject request) throws IOException {
			JSONObject data = request.getJSONObject("data");
			int no = data.getInt("no");
			for (int i = 0; i < products.size(); i++) {
				Product product = products.get(i);
				if (product.getNo() == no) {
					//참조형이라서 이렇게만 해도 원본이 바뀌는 모양...
					product.setName(data.getString("name"));
					product.setPrice(data.getInt("price"));
					product.setStock(data.getInt("stock"));
					break;
				}
			}
			//일단 결과를 클라이언트에 대답한다...오류나면 실패 메시지를 보내야 하는데...
			JSONObject response = new JSONObject();
			response.put("status", "success");
			//빈 데이터를 왜 넣지? 차라리 상품 목록을 보내야 하지 않나?
			response.put("data", new JSONObject());
			dos.writeUTF(response.toString());
			dos.flush();
		}

		private void delete(JSONObject request) throws IOException {
			JSONObject data = request.getJSONObject("data");
			int no = data.getInt("no");
			for (int i = 0; i < products.size(); i++) {
				Product product = products.get(i);
				if (product.getNo() == no) {
					//참조형이라서 이렇게만 해도 원본이 바뀌는 모양...
					products.remove(product);
					break;
				}
			}
			//일단 결과를 클라이언트에 대답한다...오류나면 실패 메시지를 보내야 하는데...
			JSONObject response = new JSONObject();
			response.put("status", "success");
			//빈 데이터를 왜 넣지? 차라리 상품 목록을 보내야 하지 않나?
			response.put("data", new JSONObject());
			dos.writeUTF(response.toString());
			dos.flush();
		}

		private void close() {
			try {
				socket.close();
				System.exit(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
