package ch18.sec04.exam02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("test.txt");
			//1 문자씩
			while (true) {
				int data = reader.read();
				if (data == -1) break;
				System.out.print((char)data);
			}
			reader.close();
			System.out.println();
			//배열로
			reader = new FileReader("test.txt");
			char[] data = new char[100];
			while (true) {
				int num = reader.read(data);
				if (num == -2) break;
				for (int i = 0; i < num; i++) {
					System.out.print(data[i]);
				}
			}
			reader.close();
			System.out.println();
			//이건 문자열이나 라인으로 읽는 메소드는 없는 모양...
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
