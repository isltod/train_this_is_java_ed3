package ch15.sec03.exam02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HsahSetExample {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		set.add(new Member("김길동", 25));
		set.add(new Member("박영식", 47));
		set.add(new Member("최두만", 33));
		System.out.println("총 객체 수: " + set.size());
		
		Member rm = null;
		Iterator<Member> iterator = set.iterator();
		while (iterator.hasNext()) {
			Member m = iterator.next();
			System.out.println(m);
			
			if (m.name == "김길동") {
				rm = m;
			}
		}
		System.out.println();

		set.remove(rm);
		System.out.println("총 객체 수: " + set.size());
		for (Member m : set) {
			System.out.println(m);
		}
	}
}
