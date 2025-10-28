package ch11.sec03.exam03;

public class ExceptionHandlingExample {
	public static void main(String[] args) {
		String[] arr = {"100", "1oo", null, "200"};
		for (int i = 0; i < arr.length; i++) {
			try {
				int value = Integer.parseInt(arr[i]);
				System.out.println("array[" + i + "]: " + value);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
			} catch (NullPointerException | NumberFormatException e) {
				// 2 이상의 예외를 연결해서 사용할 때는 | (OR) 연산자 사용
				System.out.println("배열 인덱스가 없거나 정수가 아닙니다.");
			} catch (Exception e) {
				// 더 일반적인 예외는 항상 뒤에
				System.out.println("배열 인덱스에 문제가 있습니다.");
			}
		}
	}
}
