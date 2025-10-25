package ch06.sec08.exam04;

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		// 정사각형
		double area = myCalc.areaRectangle(10);
		System.out.println("정사각형 넓이: " + area);
		// 직사각형
		area = myCalc.areaRectangle(10, 20);
		System.out.println("직사각형 넓이: " + area);
	}
}
