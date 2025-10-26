package ch09.sec06.exam03;

public class ButtonExample {
	public static void main(String[] args) {
		Button button = new Button();
		
		// 먼저 버튼 클릭 인터페이스를 구현하고
		class OKListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("OK 버튼을 클릭했습니다.");
			}
		}
		
		// 일단 실행될 클래스 멤버 필드에 OKListener를 넣어두고
		button.setClickListener(new OKListener());
		// 버튼 클래스의 click()을 호출하면 이 OKListener가 실행되는데...
		button.click();
		// 이게 실행되면 다시 위에 OKListener의 onClick이 실행된다는 복잡하게 왔다갔다하는 구조라...
	}
}
