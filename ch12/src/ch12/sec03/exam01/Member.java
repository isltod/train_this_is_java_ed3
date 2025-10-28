package ch12.sec03.exam01;

public class Member {
	public String id;
	public Member(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Member target) {
			if (id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}
}
