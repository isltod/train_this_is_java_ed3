package ch12.ex.problem15;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalcDaysExample {
	public static void main(String[] args) {
		LocalDateTime endDate = LocalDateTime.of(2025, 12, 31, 0, 0, 0);
		LocalDateTime now =LocalDateTime.now();
		long days = now.until(endDate, ChronoUnit.DAYS);
		System.out.println(days);
	}
}
