package ch06.ex;

public class ShopService {
	private ShopService() {
		// TODO Auto-generated constructor stub
	}
	private static ShopService ss = new ShopService();
	
	static ShopService getInstance() {
		return ss;
	}
}
