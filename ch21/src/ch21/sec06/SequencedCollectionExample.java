package ch21.sec06;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;
import java.util.SequencedSet;

public class SequencedCollectionExample {
	public static void main(String[] args) {
		SequencedSet<String> nameSet = new LinkedHashSet<>();
		
		nameSet.add("김길동");
		nameSet.addFirst("김길동");
		nameSet.addFirst("이길동");
		
		nameSet.addLast("조길동");
		nameSet.addLast("조길동");
		nameSet.addLast("홍길동");
		
		System.out.println(nameSet .toString());
		
		nameSet  = nameSet .reversed();
		System.out.println(nameSet .toString());
		
		nameSet.removeFirst();
		nameSet.removeLast();
		System.out.println(nameSet.toString());
	}
}
