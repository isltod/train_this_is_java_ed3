package ch18.ex.problem7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example {
	public static void main(String[] args) {
		String filePath = "../ch02/src/ch02/sec01/VariableInitializtionExample.java";
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			int rowNum = 0;
			String rowData;
			while (true) {
				rowData = br.readLine();
				if (rowData == null) break;
				rowNum++;
				System.out.println(rowNum + ": " + rowData);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
