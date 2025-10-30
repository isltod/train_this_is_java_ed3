package ch15.sec05.exam04;

import java.util.TreeSet;

public class ComapratorExample {
	public static void main(String[] args) {
		//마지막에 new FruitComparator()로 비교 클래스 주는 것이 핵심...
		TreeSet<Fruit> treeSet = new TreeSet<>(new FruitComparator());
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		for (Fruit fruit: treeSet) {
			System.out.println(fruit.name + ": " + fruit.price);
		}
	}
}
