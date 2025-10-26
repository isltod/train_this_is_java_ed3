package ch08.sec07;

public interface Service {
	private void defaultCommon() {
		System.out.println("defaultMethod1 중복 코드");
		System.out.println("defaultMethod2 중복 코드");
	}
	default void defaultMethod1() {
		System.out.println("defaultMethod1 종속 코드");
		defaultCommon();
	}
	default void defaultMethod2() {
		System.out.println("defaultMethod2 종속 코드");
		defaultCommon();
	}
	// static은 static만 호출할 수 있으니까... 정적 메소드 중복코드는 private static으로...
	private static void staticCommon() {
		System.out.println("staticMethod1 중복 코드");
		System.out.println("staticMethod2 중복 코드");
	}
	static void staticMethod1() {
		System.out.println("staticMethod1 종속 코드");
		staticCommon();
	}
	static void staticMethod2() {
		System.out.println("staticMethod2 종속 코드");
		staticCommon();
	}
}
