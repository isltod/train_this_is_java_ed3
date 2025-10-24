package ch02.sec04;

public class FloatDoubleExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float var1 = 0.12345678901234567489f;	// 소수 형식 리터럴은 기본이 double, float에 대입하면 오류
		double var2 = 0.1234567890123456789;
		System.out.println(var1);
		System.out.println(var2);
		
		double var3 = 3e6;
		float var4 = 3e6f;	// 마찬가지로 이것도 double로 보니 float에 대입하면 오류
		double var5 = 2e-3;
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		
	}

}
