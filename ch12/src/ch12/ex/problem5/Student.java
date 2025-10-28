package ch12.ex.problem5;

public class Student {
	private String studentNum;
	public Student(String studentNum) {
		// TODO Auto-generated constructor stub
		this.studentNum = studentNum;
	}
	public String getStudentNum() {
		return studentNum;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Student target) {
			if (this.hashCode() == target.hashCode()) {
				if (studentNum.equals(target.getStudentNum())) {
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hashCode = studentNum.hashCode();
		return hashCode;
	}
}
