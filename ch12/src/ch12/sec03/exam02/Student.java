package ch12.sec03.exam02;import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class Student {
	private int no;
	private String name;
	public Student(int no, String name) {
		// TODO Auto-generated constructor stub
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hashCode = no + name.hashCode();
		return hashCode;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Student target) {
			if (no == target.getNo() && name.equals(target.getName())) {
				return true;
			}
		}
		return false;
	}
}
