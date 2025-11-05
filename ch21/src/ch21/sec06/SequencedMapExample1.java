package ch21.sec06;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.TreeSet;

public class SequencedMapExample1 {
	public static void main(String[] args) {
		SequencedMap<Integer, String> nameMap = new LinkedHashMap<>();
		
		nameMap.putFirst(1, "김길동");
		nameMap.putFirst(2, "박길동");
		nameMap.putFirst(3, "이길동");
		
		nameMap.putLast(2, "마길동");
		nameMap.putLast(4, "조길동");
		nameMap.putLast(5, "홍길동");
		
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
