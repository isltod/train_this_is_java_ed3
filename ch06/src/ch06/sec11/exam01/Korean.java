package ch06.sec11.exam01;

public class Korean {
	final String nation = "대한민국";
	final String ssn;
	String name;
	public Korean(String ssn, String name) {
		// TODO Auto-generated constructor stub
		this.ssn = ssn;
		this.name = name;
		// final은 딱 한 번만 입력 가능...위에서 벌써 초기화했으면 생성자에서는 못한다...
		this.nation = "USA";
	}
}
