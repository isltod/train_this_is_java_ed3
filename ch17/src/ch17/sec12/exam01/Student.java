package ch17.sec12.exam01;

public class Student {
	private String name;
	private int score;
	private String sex;
	
	public Student(String name, int score, String sex) {
		this.name = name;
		this.score = score;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public int getScore() {
		return score;
	}
}
