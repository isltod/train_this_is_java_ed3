package ch12.sec08;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneExample {
	public static void main(String[] args) {
		//이건 getInstance도 아니고 getTimeZone? 정말 통일성 없이 지저분하네 자바...
		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar now = Calendar.getInstance(timeZone);
		MakeDate md = new MakeDate();
		String strDate = md.getDateString(now);
		System.out.println(strDate);
		
		//타임존 다 출력해보자...
		String[] availableIDs = TimeZone.getAvailableIDs();
		for (String id: availableIDs) {
			System.out.println(id);
		}
	}
}
