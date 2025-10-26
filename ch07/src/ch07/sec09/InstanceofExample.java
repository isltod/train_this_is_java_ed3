package ch07.sec09;

public class InstanceofExample {
	public static void personInfo(Person person) {
		System.out.println("name: " + person.name);
		person.walk();
		
		// person 객체가 원래 student 였는지 확인해서 뭔가 더 시키기...
		if (person instanceof Student) {
			Student student1 = (Student) person;
			System.out.println("Student No: " + student1.studentNo);
			student1.study();
		}
		
		// 또는 새로운 방법으로
		if (person instanceof Student student2) {
			System.out.println("Student No: " + student2.studentNo);
			student2.study();
		}
	}
	public static void main(String[] args) {
		Person p1 = new Person("홍길동");
		personInfo(p1);
		System.out.println();
		Person p2 = new Student("김길동", 15);
		personInfo(p2);
	}
}
