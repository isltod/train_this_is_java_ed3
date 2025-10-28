package ch12.ex.problem5;

import java.util.HashSet;

public class StudentExample {
	public static void main(String[] args) {
		HashSet<Student> hashSet = new HashSet<Student>();
		
		hashSet.add(new Student("1"));
		hashSet.add(new Student("1"));	// 요게 hashCode와 equals를 재정의 해서 먹히는 코드? 그럼 hashCode를 재정의하지 않으면 3이 된다...
		hashSet.add(new Student("2"));
		
		System.out.println("저장된 Student 수: " + hashSet.size());
	}
}
