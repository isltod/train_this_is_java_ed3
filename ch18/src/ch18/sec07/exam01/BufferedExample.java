package ch18.sec07.exam01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedExample {
	public static void main(String[] args) {
		String orginalFilePath = "originalFile1.jpg";
		String targetFilePath1 = "targetFile1.jpg";
		String targetFilePath2 = "targetFile2.jpg";
		try {
			//그냥 스트림으로 복사 테스트
			FileOutputStream fos1 = new FileOutputStream(targetFilePath1);
			FileInputStream fis1 = new FileInputStream(orginalFilePath);
			long nonBufferTime = copy(fis1, fos1);
			System.out.println("버퍼 사용 X: " + nonBufferTime + " ns");
			fos1.close();
			fis1.close();
			
			//버퍼 스트림으로 복사 테스트
			FileInputStream fis2 = new FileInputStream(orginalFilePath);
			FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
			BufferedInputStream bis = new BufferedInputStream(fis2);
			BufferedOutputStream bos = new BufferedOutputStream(fos2);
			long bufferedTime = copy(bis, bos);
			System.out.println("버퍼 사용 O: " + bufferedTime + " ns");
			bis.close();
			bos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static long copy(InputStream is, OutputStream os) {
		long start = System.nanoTime();
		try {
			while (true) {
					int data = is.read();
					if (data == -1) break;
					os.write(data);
			}
		os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.nanoTime();
		return (end - start);
	}
}
