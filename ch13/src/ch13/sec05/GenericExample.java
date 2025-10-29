package ch13.sec05;

public class GenericExample {
	public static void main(String[] args) {
		//registerCourse1의 매개변수는 ? 만 있어서 정말 아무 객체나 다 들어간다...
		//applicant의 생성자를 불러야 하는데, 거기 매개변수가 generic이라서 매개변수 앞에 같은 타입 <> 붙이기...
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		System.out.println();
		
		//but registerCounrse2는 extends Student가 있어서 Student와 자식 객체들만 가능
		//아래 두개는 컴파일 에러...
//		Course.registerCourse2(new Applicant<Person>(new Person()));
//		Course.registerCourse2(new Applicant<Worker>(new Worker()));
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		System.out.println();
		
		//but registerCounrse2는 super Worker가 있어서 Worker와 부모 객체들만 가능
		//아래 세개는 컴파일 에러...
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
//		Course.registerCourse3(new Applicant<Student>(new Student()));
//		Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
//		Course.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
	}
}
