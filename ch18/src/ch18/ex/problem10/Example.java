package ch18.ex.problem10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example {
	public static void main(String[] args) {
		String orignalFilePath = "./test.jpg";
		String targetFilePath = "./testDir/test1.jpg";
		System.out.println("원본 파일 경로: " + orignalFilePath);
		System.out.println("복사 파일 경로: " + targetFilePath);
		File originalFile = new File(orignalFilePath);
		if (!originalFile.exists()) {
			System.out.println("원본 파일이 존재하지 않습니다.");
			System.exit(0);
		}
		File targetFile = new File(targetFilePath);
		File parentDir = targetFile.getParentFile();
		if (!parentDir.exists()) parentDir.mkdirs();
		try {
			InputStream is = new FileInputStream(originalFile);
			BufferedInputStream bis = new BufferedInputStream(is);
			OutputStream os = new FileOutputStream(targetFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			int num = 0;
			byte[] data = new byte[1024];
			while (true) {
				num = bis.read(data);
				if (num == -1) break;
				bos.write(data, 0, num);
			}
			bos.flush();
			bis.close();
			bos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("복사가 성공되었습니다.");
	}
}
