package ch21.sec01;

import java.awt.MenuComponent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VarExample2 {
	public static void main(String[] args) {
		method1();
		method2();
	}

	private static void method2() {
		Map<String, Integer> map = new HashMap<>();
		map.put("신용권", 85);
		map.put("홍길동", 95);
		map.put("동장군", 80);
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entIterator = entrySet.iterator();
		while (entIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entIterator.next();
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + ": " + val);
		}
	}

	private static void method1() {
		var map = new HashMap<String, Integer>();
		map.put("신용권", 85);
		map.put("홍길동", 95);
		map.put("동장군", 80);
		
		var entrySet = map.entrySet();
		var entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			var entry =entryIterator.next();
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + ": " + val);
		}
	}
}
