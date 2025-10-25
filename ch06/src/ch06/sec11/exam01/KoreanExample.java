package ch06.sec11.exam01;

import javax.security.auth.callback.NameCallback;

public class KoreanExample {
	public static void main(String[] args) {
		Korean k1 = new Korean("123456-1234567", "감자바우");
		// final이고 뭐고 읽는 것은 아무 문제 없는데...
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		// 쓰는 것은 final은 안된다..
		k1. nation = "USA";
		k1. ssn = "123-343-678";
		k1.name = "고구마";
	}
}
