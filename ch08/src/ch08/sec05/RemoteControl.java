package ch08.sec05;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 구현하는 모든 개체들에 공통적인 기능은 default로 미리 만들기...
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리합니다.");
			// 실행 코드가 있으니, 구현하는 개체들은 어차피 setVolume을 구현할테니 호출 가능...
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
}
