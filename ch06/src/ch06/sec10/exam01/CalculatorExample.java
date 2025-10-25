package ch06.sec10.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = myCalc.plus(10, 5);
		int result3 = myCalc.minus(10, 5);
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		System.out.println("result3: " + result3);
	}
}
