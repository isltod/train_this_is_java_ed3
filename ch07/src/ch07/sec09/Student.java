package ch07.sec09;

public class Student extends Person {
	public int studentNo;
	public Student(String name, int studentNo) {
		// 부모 클래스 생성자가 명시적으로 있을 때 이렇게 만드는 거 주의...
		super(name);
		this.studentNo = studentNo;
	}
	public void study() {
		System.out.println("공부를 합니다.");
	}
}
