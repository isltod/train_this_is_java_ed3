package ch11.sec04;

public class MyResource implements AutoCloseable {
	private String name;
	public MyResource(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		System.out.println("[MyResource(" + name + ") 열기]");
	}
	public String read1() {
		System.out.println("[MyResource(" + name + ") 읽기]");
		return "100";
	}
	public String read2() {
		System.out.println("[MyResource(" + name + ") 읽기]");
		return "abc";
	}

	@Override
	public void close() throws Exception {
		// 실제로는 close할 게 없으니까 시늉만...
		System.out.println("[MyResource(" + name + ") 닫기]");
	}
}
