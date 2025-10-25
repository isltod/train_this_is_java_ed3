package ch06.ex;

public class MemberService {
	public String id;
	public String password;
	
	public boolean login(String id, String password) {
		if (id == "hong" && password == "12345") {
			return true;
		} else {
			return false;
		}
	}
	
	public void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다");
	}
}
