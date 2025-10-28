package ch12.sec08;

import java.util.Calendar;

public class MakeDate {
	public String getDateString(Calendar now) {
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch (week) {
		case Calendar.MONDAY:		strWeek = "월"; break;
		case Calendar.TUESDAY:		strWeek = "화"; break;
		case Calendar.WEDNESDAY:	strWeek = "수"; break;
		case Calendar.THURSDAY:		strWeek = "목"; break;
		case Calendar.FRIDAY:		strWeek = "금"; break;
		case Calendar.SATURDAY:		strWeek = "토"; break;
		default:					strWeek = "일"; break;
		}
		int amPm = now.get(Calendar.AM);
		String strAmPm = null;
		if (amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		String date = new StringBuilder(year + "년 ")
				.append(month + "월 ")
				.append(day + "일 ")
				.append(strWeek + "요일 ")
				.append(strAmPm + " ")
				.append(hour + "시 ")
				.append(minute + "분 ")
				.append(second + "초 ")
				.toString();
		return date;
	}
}
