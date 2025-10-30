package ch15.ex.problem8;

public class Student {
	public int studentNum;
	public String name;
	public Student(int studentNum, String name) {
		// TODO Auto-generated constructor stub
		this.studentNum = studentNum;
		this.name = name;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return studentNum;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Student target) {
			return (studentNum == target.studentNum);
		}
		return false;
	}
}
