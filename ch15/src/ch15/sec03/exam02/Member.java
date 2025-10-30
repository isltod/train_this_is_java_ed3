package ch15.sec03.exam02;

public class Member {
	public String name;
	public int age;
	public Member(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}
	//집합 객체에 넣을 때 동등비교를 위해서 hashCode와 equals 재정의
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode() + age;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member target) {
			return (name.equals(target.name)) && (target.age == age);
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " " + age;
	}
}
