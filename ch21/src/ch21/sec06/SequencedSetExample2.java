package ch21.sec06;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;
import java.util.SequencedSet;
import java.util.TreeSet;

public class SequencedSetExample2 {
	public static void main(String[] args) {
		SequencedSet<String> nameSet = new TreeSet<>();
		
		nameSet.add("김길동");
//		nameSet.addFirst("김길동");	//TreeSet에서는 위치 지정이 에러
		
//		nameSet.addLast("조길동");	//TreeSet에서는 위치 지정이 에러
		nameSet.add("조길동");
		nameSet.add("탁길동");
		nameSet.add("홍길동");
		
		System.out.println(nameSet .toString());
		
		nameSet  = nameSet .reversed();
		System.out.println(nameSet .toString());
		
		nameSet.removeFirst();
		nameSet.removeLast();
		System.out.println(nameSet.toString());
	}
}
