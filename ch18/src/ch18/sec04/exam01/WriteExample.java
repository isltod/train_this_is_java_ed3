package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("test.txt");
			//한 문자씩
			char a = 'A';
			char b = 'B';
			writer.write(a);
			writer.write(b);
			//배열
			char[] arr = {'C', 'D', 'E'};
			writer.write(arr);
			//문자열
			writer.write("FGH");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
