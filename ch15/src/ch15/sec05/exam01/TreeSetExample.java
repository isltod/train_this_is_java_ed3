package ch15.sec05.exam01;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		
		for (int i = 0; i < 10; i++) {
			scores.add((int) (Math.random() * 100) + 1);
		}
		
		//순서 없이 하나씩 꺼내오기 - 그래도 정렬됨
		for (Integer s : scores) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		//특정 객체, 비교해서
		System.out.println("가장 높은 점수: " + scores.last());
		System.out.println("가장 낮은 점수: " + scores.first());
		System.out.println("50점 바로 위 점수: " + scores.higher(50));
		System.out.println("50점 바로 아래 점수: " + scores.lower(50));
		System.out.println("50점 이상 점수: " + scores.tailSet(50));
		System.out.println("50점 이하 점수: " + scores.headSet(50));
		
		//내림차순
		NavigableSet<Integer> descendingScores = scores.descendingSet();
		for (int s : descendingScores) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		//범위검색
		NavigableSet<Integer> rangeSet = scores.subSet(30, true, 80, false);
		for (Integer s : rangeSet) {
			System.out.print(s + " ");
		}
	}
}
