package ch07.sec10.exam02;

public abstract class Animal {
	// 요건 일반 메서드이므로 override 안해도 되고...
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	// 요건 추상 메서드이므로, 중괄호 없고, 꼭 override 해야 하고, 안 하려면 그놈도 abstract여야 하고
	public abstract void sound();
}
