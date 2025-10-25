package ch06.sec15;

public class Singleton {
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	private static Singleton singleton = new Singleton();
	
	public static Singleton getInstance() {
		return singleton;
	}
}
