package ch03.sec05;

public class InfinityAndNaNCheckExample {
	public static void main(String[] args) {
		int pencils = 534;
		int students = 30;
		int pencilsPerStudents = pencils / students;
		System.out.println(pencilsPerStudents);
		int x = 5;
		double y = 0.0;
//		double z = x / y;
		double z = x % y;
		
		// 잘못된 코드
		System.out.println(z + 2);
		
		// 맞는 코드
		if (Double.isInfinite(z) || Double.isNaN(z)) {
			System.out.println("값 산출 불가");
		} else {
			System.out.println(z + 2);
		}
	}
}
