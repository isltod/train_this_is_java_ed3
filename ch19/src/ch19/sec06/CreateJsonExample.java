package ch19.sec06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {
	public static void main(String[] args) {
		JSONObject root = new JSONObject();
		root.put("id", "winter");
		root.put("name", "한겨울");
		root.put("age", 25);
		root.put("student", true);

		JSONObject tel = new JSONObject();
		tel.put("home", "02-123-4567");
		tel.put("mobile", "010-123-4567");
		root.put("tel", tel);
		
		JSONArray skill = new JSONArray();
		skill.put("java");
		skill.put("c");
		skill.put("c++");
		root.put("skill", skill);
		
		//JSON 문자열로 완성
		String json = root.toString();
		
		System.out.println(json);
		
		//JSON 파일로 쓰기
		try {
			Writer writer = new FileWriter("member.json");
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//파일에서 읽기
		try {
			BufferedReader br = new BufferedReader(new FileReader("member.json"));
			json = br.readLine();
			br.close();
			
			root = new JSONObject(json);
			System.out.println("id: " + root.getString("id"));
			System.out.println("name: " + root.getString("name"));
			System.out.println("age: " + root.getInt("age"));
			System.out.println("student: " + root.getBoolean("student"));
			
			tel = root.getJSONObject("tel");
			System.out.println("home: " + tel.getString("home"));
			System.out.println("mobile: " + tel.getString("mobile"));
			
			skill = root.getJSONArray("skill");
			System.out.print("skill: ");
			for (int i = 0; i < skill.length(); i++) {
				System.out.print(skill.getString(i) + ", ");
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
