package ch21.sec06;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class SequencedSetExample1 {
	public static void main(String[] args) {
		SequencedCollection<String> nameList = new ArrayList<>();
		
		nameList.add("김길동");
		nameList.addFirst("박길동");
		nameList.addFirst("이길동");
		
		nameList.addLast("조길동");
		nameList.addLast("탁길동");
		nameList.addLast("홍길동");
		
		System.out.println(nameList.toString());
		
		nameList = nameList.reversed();
		System.out.println(nameList.toString());
	}
}
