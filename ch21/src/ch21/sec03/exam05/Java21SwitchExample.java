package ch21.sec03.exam05;

import java.nio.channels.Pipe.SourceChannel;

public class Java21SwitchExample {
	private static void method1(Drawable drawable) {
		String result1 = switch (drawable) {
		case Shape s when s == Shape.LINE -> "선을 그립니다.";
		case Shape s when s == Shape.TRIANGLE -> "삼각형을 그립니다.";
		case Shape s when s == Shape.RECTANGLE -> "사각형을 그립니다.";
		case Image i when i == Image.JPEG -> "Jpeg 이미지를 그립니다.";
		case Image i when i == Image.PNG -> "png 이미지를 그립니다.";
		case null, default -> "도형을 그리지 않습니다.";
		};
		System.out.println(result1);
	}
	public static void main(String[] args) {
		method1(Shape.TRIANGLE);
	}
}
