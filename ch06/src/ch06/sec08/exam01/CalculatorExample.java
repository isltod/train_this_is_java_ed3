package ch06.sec08.exam01;

import java.nio.channels.Pipe.SourceChannel;

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		int result1 = myCalc.plus(5, 6);
		System.out.println("plus: " + result1);
		double result2 = myCalc.divide(10, 4);
		System.out.println("divide: " + result2);
		myCalc.powerOff();
	}
}
