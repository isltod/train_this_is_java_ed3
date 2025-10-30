package ch16.sec02.exam02;

public class ButtonExample {
	public static void main(String[] args) {
		//먼저 OK 버튼 만들고
		Button btnOk = new Button();
		//버튼 객체의 ClickListner 인터페이스에 람다식으로 구현 객체 대입
		btnOk.setClickListner(() -> {
			System.out.println("OK 버튼을 클릭했습니다.");
		});
		//그리고 버튼 클릭
		btnOk.click();
		
		//다시 Cancel 버튼 만들고
		Button btnCancel = new Button();
		//버튼 객체의 ClickListner 인터페이스에 람다식으로 구현 객체 대입
		btnCancel.setClickListner(() -> System.out.println("Cancel 버튼을 클릭했습니다."));
		//그리고 버튼 클릭
		btnCancel.click();
	}
}
