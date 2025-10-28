package ch12.sec12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintAnnotationExample {
	public static void main(String[] args) throws Exception {
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		for (Method method : declaredMethods) {
			//여기 메소드가 실제로 실행될 건데...이걸 이렇게가 아니고 정상적으로 실행되는 환경이란...
			PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
			//이렇게 직접 어노테이션이 할 일을 해주고...
			printLine(printAnnotation);
			//실제 실행되야하는 메소드 부르기 - 이거 때문에 위에 throws 필요
			method.invoke(new Service());
			printLine(printAnnotation);
		}
	}
	public static void printLine(PrintAnnotation printAnnotation) {
		if (printAnnotation != null) {
			int number = printAnnotation.number();
			String value = printAnnotation.value();
			for (int i = 0; i < number; i++) {
				System.out.print(value);
			}
			System.out.println();
		}
	}
}
