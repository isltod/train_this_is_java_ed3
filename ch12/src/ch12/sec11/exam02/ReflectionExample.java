package ch12.sec11.exam02;

import java.lang.reflect.Constructor;

public class ReflectionExample {
	public static void main(String[] args) {
		Class clazz = Car.class;
		
		// 생성자 정보
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.print(constructor.getName() + "(");
			Class[] parameters = constructor.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
	}
	public static void printParameters(Class[] parameters) {
		for (int i = 0; i < parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if (i < parameters.length - 1) {System.out.print(", ");}
		}
	}
}
