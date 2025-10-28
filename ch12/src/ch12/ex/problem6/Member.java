package ch12.ex.problem6;

public class Member {
	private String id;
	private String name;
	public Member(String id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + ": " + name;
	}
}
