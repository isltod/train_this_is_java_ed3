package ch16.sec05.exam03;

public class Person {
	public Member getMember1(Creatable1 creatable) {
		String id = "winter";
		//뒤에 메소드가 결국은 생성자여야 한다는 얘기...
		Member member = creatable.create(id);
		return member;
	}
	public Member getMember2(Creatable2 creatable) {
		String id = "summer";
		String name = "한여름";
		//뒤에 메소드가 결국은 생성자여야 한다는 얘기...
		Member member = creatable.create(id, name);
		return member;
	}
}
