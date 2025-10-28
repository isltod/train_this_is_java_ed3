package ch12.sec09;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatExample {
	public static void main(String[] args) {
		double num = 123456.789;
		DecimalFormat df;
		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		df = new DecimalFormat("#,###.# %");
		System.out.println(df.format(num));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		Date now = new Date();
		System.out.println(sdf.format(now));
		sdf = new SimpleDateFormat("올해의 D번째 날");
		System.out.println(sdf.format(now));
	}
}
