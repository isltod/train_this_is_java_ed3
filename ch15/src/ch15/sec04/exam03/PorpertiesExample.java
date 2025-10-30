package ch15.sec04.exam03;

import java.io.IOException;
import java.util.Properties;

public class PorpertiesExample {
	public static void main(String[] args) {
		Properties properties = new Properties();
		
		//파일 로드
		try {
			properties.load(PorpertiesExample.class.getResourceAsStream("database.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//키값으로 읽기
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String admin = properties.getProperty("admin");
		System.out.println("driver: " + driver);
		System.out.println("url: " + url);
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		System.out.println("admin: " + admin);
	}
}
