package ch21.sec06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.SequencedCollection;

public class UnmodifiableExample {
	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		// TODO Auto-generated method stub
		SequencedCollection<String> collection = new ArrayList<>();
		
		collection.addFirst("데이터1");
		collection.addFirst("데이터2");
		collection.addFirst("데이터3");
		
		//다른 메소드로 수정할 수 없는 순차 컬렉션 전달
		method2(Collections.unmodifiableCollection(collection));
	}

	private static void method2(Collection<String> unmodifiableCollection) {
		// TODO Auto-generated method stub
		for (String data: unmodifiableCollection) {
			System.out.println(data);
		}
		
//		unmodifiableCollection.remove("데이터1");	//수정할 수 없으므로 지우면 에러
		
	}
}
