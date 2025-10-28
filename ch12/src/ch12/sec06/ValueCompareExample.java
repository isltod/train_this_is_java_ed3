package ch12.sec06;

public class ValueCompareExample {
	public static void main(String[] args) {
		//-128~127 초과할 경우
		Integer obj1 = 300;
		Integer obj2 = 300;
		System.out.println("obj1: " + obj1);
		System.out.println("obj2: " + obj2);
		System.out.println("but obj1==obj2: " + (obj1 == obj2));
		System.out.println("so... obj1.equals(obj2): " + obj1.equals(obj2));
		System.out.println();
		
		//-128~127 내의 값은 달라진다...
		Integer obj3 = 10;
		Integer obj4 = 10;
		System.out.println("obj3: " + obj3);
		System.out.println("obj4: " + obj4);
		System.out.println("obj3==obj4: " + (obj3 == obj4));
	}
}
