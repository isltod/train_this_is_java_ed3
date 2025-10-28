package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeCompareExample {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		LocalDateTime startDateTime =LocalDateTime.of(2022, 1, 1, 0, 0, 0);
		System.out.println("시작일: " + startDateTime.format(dtf));
		LocalDateTime enDateTime =LocalDateTime.of(2025, 12, 25, 12, 30, 0);
		System.out.println("종료일: " + enDateTime.format(dtf));
		LocalDateTime now =LocalDateTime.now();
		if (now.isBefore(enDateTime)) {
			System.out.println("아직 시간이 많이 남았네...");
		}
		long reaminYears = now.until(enDateTime, ChronoUnit.YEARS);
		long reaminMonths = now.until(enDateTime, ChronoUnit.MONTHS);
		long reaminDays = now.until(enDateTime, ChronoUnit.DAYS);
		long reaminHours = now.until(enDateTime, ChronoUnit.HOURS);
		long reaminMinutes = now.until(enDateTime, ChronoUnit.MINUTES);
		long reaminSeconds = now.until(enDateTime, ChronoUnit.SECONDS);
		System.out.println("남은 해: " + reaminYears);
		System.out.println("남은 시간: " + reaminHours);
	}
}
