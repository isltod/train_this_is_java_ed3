package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.w3c.dom.ls.LSOutput;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 92, "남"));
		list.add(new Student("김수영", 87, "여"));
		list.add(new Student("감자바", 95, "남"));
		list.add(new Student("오해영", 93, "여"));
		
		List<Student> maleList = list.stream()
				.filter(s -> s.getSex() == "남")
				.collect(Collectors.toList());				//또는 그냥 toList();
		maleList.stream()
				.forEach(s -> System.out.println(s.getName()));
		
		Map<String, Integer> map = list.stream()
				.collect(Collectors.toMap(s -> s.getName(), s -> s.getScore()));
		System.out.println(map);
	}
}
