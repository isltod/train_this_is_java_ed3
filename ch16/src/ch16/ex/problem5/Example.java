package ch16.ex.problem5;

public class Example {
	public static void main(String[] args) {
		Button btnOk = new Button();
		btnOk.setClickListner(() -> {
			System.out.println("OK 버튼을 클릭했습니다.");
		});
		btnOk.click();
		
		Button btnCancel = new Button();
		btnCancel.setClickListner(() -> {
			System.out.println("Cancel 버튼을 클릭했습니다.");
		});
		btnCancel.click();
	}
}
