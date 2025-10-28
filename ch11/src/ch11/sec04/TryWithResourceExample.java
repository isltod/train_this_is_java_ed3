package ch11.sec04;

public class TryWithResourceExample {
	public static void main(String[] args) {
		try (MyResource res = new MyResource("A")) {
			String data = res.read1();
			int value = Integer.parseInt(data);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외 처리: " + e.getMessage());
		}
		System.out.println();
		try (MyResource res = new MyResource("A")) {
			String data = res.read2();
			int value = Integer.parseInt(data);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외 처리: " + e.getMessage());
		}
		System.out.println();
		
		// 자바 9부터는 괄호 위에 선언해서 좀 더 깨끗하게... 
		MyResource res1 = new MyResource("A");
		MyResource res2 = new MyResource("B");
		// 구분자가 ,가 아니라 ;임에 주의
		try (res1; res2) {
			String data1 = res1.read1();
			String data2 = res2.read2();
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외 처리: " + e.getMessage());
		}
	}
}
