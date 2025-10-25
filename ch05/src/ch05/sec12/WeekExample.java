package ch05.sec12;

import java.util.Calendar;

public class WeekExample {
	public static void main(String[] args) {
		// enum 타입은 null로 만들어 사용하는 건가?
		Week today = null;
		// 시스템 날짜 시간 정보를 가진 객체라는데...
		Calendar calendar = Calendar.getInstance();
		// 요일은 번호로 얻어온다는데, 클래스 DAY_OF_WEEK를 매개변수로 인스턴스 get을 해? 왜 이렇게 복잡하게 만들었지?
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("calendar.DAY_OF_WEEK: " + calendar.DAY_OF_WEEK);
		switch (week) {
		case 1 -> today = Week.SUNDAY;
		case 2 -> today = Week.MONDAY;
		case 3 -> today = Week.TUESDAY;
		case 4 -> today = Week.WEDNESDAY;
		case 5 -> today = Week.THURSDAY;
		case 6 -> today = Week.FRIDAY;
		default -> today = Week.STAURDAY;
		}
		System.out.println("today: " + today);
		if (today == Week.SUNDAY) {
			System.out.println("일요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바를 공합니다.");
		}
	}
}
