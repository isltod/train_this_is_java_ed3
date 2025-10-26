package ch08.sec08;

public class MultiInterfaceImplExample {
	public static void main(String[] args) {
		// 여기서는 결국 기계는 하나, SmartTelevision, 이걸 뭔 interface로 이용하느냐...
		SmartTelevision tv = new SmartTelevision();
		
		//먼저 리모콘 이용
		RemoteControl rc = tv;
		rc.turnOn();
		rc.turnOff();
		
		// 다음 검색하려면 서치 이용
		Search search =tv;
		search.search("http://youtube.com");
	}
}
