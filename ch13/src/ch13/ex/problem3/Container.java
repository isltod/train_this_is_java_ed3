package ch13.ex.problem3;

public class Container<N, J> {
	private N n;
	private J j;
	public void set(N n, J j) {
		this.n = n;
		this.j = j;
	}
	public N getKey() {
		return n;
	}
	public J getValue() {
		return j;
	}
}
