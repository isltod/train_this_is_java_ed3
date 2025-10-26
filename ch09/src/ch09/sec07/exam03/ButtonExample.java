package ch09.sec07.exam03;

public class ButtonExample {
	public static void main(String[] args) {
		Button button = new Button();
		
		// 아래 코드를 버튼 종류별로 만들고 다시 호출하는 것이 아니라, 호출할 때 만든다는데...정말 이게 좋은가?
//		class OKListener implements Button.ClickListener {
//			@Override
//			public void onClick() {
//				System.out.println("OK 버튼을 클릭했습니다.");
//			}
//		}
		
		// 일단 실행될 멤버 필드에 바로 인터페이스를 구현해서 익명으로 넣어두고
		button.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("OK 버튼을 클릭했습니다.");
			}
		});
		// 버튼 클래스의 click()을 호출하면 이 바로 위 OK 어쩌구 익명 객체가 실행되는데...
		button.click();
		// 이게 실행되면 다시 위에 OKListener의 onClick이 실행된다는 복잡하게 왔다갔다하는 구조라...

		// Cancel은 이렇게...
		button.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}
		});
		button.click();
	}
}
