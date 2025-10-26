package ch09.sec07.exam03;

public class Button {
	// 인터페이스를 정적으로, 중첩해서? 포함해서?
	public static interface ClickListener {
		void onClick();
	}
	// 이 인터페이스를 다형성으로 사용할 필드, 그리고 그 값을 제어할 setter
	private ClickListener clickListener;
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	// 여기부터 정신없는데...일단 버튼이 클릭되었을 때 실행하는 메소드?
	public void click() {
		// 여기 onClick()은 아직 구현은 안됐지만 어쨌든 누군가는 구현할테니까...
		this.clickListener.onClick();
	}
}
