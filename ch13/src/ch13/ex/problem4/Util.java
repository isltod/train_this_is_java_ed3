package ch13.ex.problem4;

public class Util {
	// 그냥 이렇게만 해도 자동 타입 변환 룰에 의해 Pair 자리에는 하위 객체만 들어올 수 있다...
	public static <K, V> V getValue(Pair<K, V> pair, K key) {
		if (pair.getKey() == key) {
			return pair.getValue();
		} else {
			return null;
		}
	}
}
