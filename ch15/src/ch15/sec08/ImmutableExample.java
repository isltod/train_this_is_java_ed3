package ch15.sec08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableExample {
	public static void main(String[] args) {
		//List, Set, Map 수정 못하는 컬렉션
		//1. of()
		List<String> immutableList1 = List.of("A", "b", "C");
		Set<String> immutableSet1 = Set.of("A", "b", "C");
		Map<Integer, String> immutableMap1 = Map.of(1, "A", 2, "b", 3, "C");
		//2. copy
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		List<String> immutableList2 = List.copyOf(list);
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		List<String> immutableSet2 = Set.copyOf(set);
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "A");
		map.put(3, "A");
		Map<Integer, String> immutableMap2 = Map.copyOf(map);
		
		//배열에서
		String[] arr = {"A", "b", "C"};
		List<String> immutableList3 = Arrays.asList(arr);
	}
}
