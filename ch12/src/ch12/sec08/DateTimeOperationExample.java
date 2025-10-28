package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationExample {
	public static void main(String[] args) {
		//이번에는 now()냐? 웃기지도...
		LocalDateTime now =LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println("현재시간: " + now.format(dtf));
		
		//더하기 빼기는...
		LocalDateTime result1 = now.plusYears(2);
		System.out.println(result1.format(dtf));
	}
}
