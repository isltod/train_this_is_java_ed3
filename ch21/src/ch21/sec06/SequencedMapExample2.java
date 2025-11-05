package ch21.sec06;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class SequencedMapExample2 {
	public static void main(String[] args) {
		SequencedMap<Integer, String> nameMap = new TreeMap<>();
		
//		nameMap.putFirst(1, "김길동");	//TreeSet처럼 TreeMap도 위치 지정하면 에러
		
//		nameMap.putLast(2, "마길동");	//TreeSet처럼 TreeMap도 위치 지정하면 에러
		nameMap.put(3, "이길동");
		nameMap.put(2, "박길동");
		nameMap.put(1, "김길동");
		nameMap.put(5, "홍길동");
		nameMap.put(2, "마길동");
		nameMap.put(4, "탁길동");
		
		System.out.println(nameMap.toString());
		
		Map.Entry<Integer, String> firstEntry = nameMap.firstEntry();
		System.out.println("첫 번째 엔트리: " + firstEntry.getKey() + ", " + firstEntry.getValue());
		
		firstEntry = nameMap.pollFirstEntry();
		System.out.println("첫 번째 엔트리 제거: " + firstEntry.getKey() + ", " + firstEntry.getValue());
		System.out.println(nameMap.toString());
		
		Map.Entry<Integer, String> lastEntry = nameMap.lastEntry();
		System.out.println("마지막 엔트리: " + lastEntry.getKey() + ", " + lastEntry.getValue());
		
		lastEntry = nameMap.pollLastEntry();
		System.out.println("마지막 엔트리 제거: " + lastEntry.getKey() + ", " + lastEntry.getValue());
		System.out.println(nameMap.toString());

		nameMap  = nameMap .reversed();
		System.out.println(nameMap.toString());
		for (int key : nameMap.sequencedKeySet()) {
			System.out.println(key + ", " + nameMap.get(key));
		}
	}
}
