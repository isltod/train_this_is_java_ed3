package ch18.sec06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class CharacterConvertStreamExample {
	public static void main(String[] args) {
		write("문자 변환 스트림을 사용합니다.");
		String data;
		try {
			data = read();
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void write(String str) {
		OutputStream os;
		try {
			os = new FileOutputStream("test1.txt");
			Writer writer = new OutputStreamWriter(os, "UTF-8");
			writer.write(str);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String read() throws IOException {
		InputStream is = new FileInputStream("test1.txt");
		Reader reader = new InputStreamReader(is, "UTF-8");
		char[] data = new char[100];
		int num = reader.read(data);
		reader.close();
		return new String(data, 0, num);
	}
}
