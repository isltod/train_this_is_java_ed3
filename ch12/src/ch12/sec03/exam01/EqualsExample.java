package ch12.sec03.exam01;

public class EqualsExample {
	public static void main(String[] args) {
		//일단 다 new로 만드니 주소도 다른 객체들...
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		
		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}
		if (obj1.equals(obj3)) {
			System.out.println("obj1과 obj3은 동등합니다.");
		} else {
			System.out.println("obj1과 obj3은 동등하지 않습니다.");
		}
	}
}
