package ch12.ex.problem16;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.ls.LSOutput;

public class SimpleDateFormatExample {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
		Date now = new Date();
		System.out.println(sdf.format(now));
	}
}
