package ch15.ex.problem9;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("whilte", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while (keyIterator.hasNext()) {
			String id = keyIterator.next();
			int score = map.get(id);
			if (maxScore < score) {
				maxScore = score;
				name = id;
			}
			totalScore += score;
		}
		double avg = (double) totalScore / map.size();
		System.out.println("최고 점수: " + maxScore);
		System.out.println("최고 점수를 받은 아이디: " + name);
		System.out.println("평균 점수: " + avg);
	}
}
