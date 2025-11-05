package ch21.sec07;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class DefaultCharactersetExample {
	public static void main(String[] args) {
		Charset javaCharset = Charset.defaultCharset();
		System.out.println("Java 기본 문자셋: " + javaCharset);
		
		byte[] bytes = "자바".getBytes();
		System.out.println("자바 바이트 수:" + bytes.length + " bytes");
		
		File file = new File("file.txt");
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			writer.write("한글");
			writer.flush();
			writer.close();
			System.out.println("file size: " + file.length() + " bytes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
