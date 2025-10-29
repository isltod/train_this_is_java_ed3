package ch13.ex.problem4;

public class Pair<K, V> {
	private K key;
	private V value;
	public Pair(K key, V value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
