package ch13.sec05;

public class Course {
	//앞에서는 매개변수가 그냥 gerneric <T> 이라서 앞에 <T>를 붙여줬는데,
	//여기서는 매개변수가 일단 일반 클래스 Applicant이나 앞에 <T>는 없다...
	//대신 Applicant에서 사용하는 generic을 ?로 한정한다
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course1을 등록함");
	}
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course2를 등록함");
	}
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course3을 등록함");
	}
}
