package ch06.sec15;

public class SingletonExample {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		// 아래처럼 그냥 전통적으로 생성하면 컴파일 에러...
		Singleton s3 = new Singleton();
	}
}
