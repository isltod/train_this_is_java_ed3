package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("test.jpg");
			OutputStream os = new FileOutputStream("test1.jpg");
			
			is.transferTo(os);
//			byte[] data = new byte[1024];
//			while (true) {
//				int num = is.read(data);
//				if (num == -1) break;
//				os.write(data, 0, num);
//			}
			os.flush();
			is.close();
			os.close();
			System.out.println("복사가 잘 되었습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
