package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExample {
	public static void main(String[] args) {
		try {
			FileInputStream is = new FileInputStream("test3.db");
			byte[] data = new byte[100];
			int num = 0;
			while (true) {
				num = is.read(data);
				if (num == -1) break;
				System.out.println(num);
				for (int i = 0; i < num; i++) {
					System.out.println(data[i]);
				}
			}
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
