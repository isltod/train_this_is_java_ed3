package ch07.ex;

public class Parent {
	public String nation;
	public Parent() {
		// TODO Auto-generated constructor stub
		this("대한민국");
		System.out.println("Parent() call");
	}
	public Parent(String nation) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
