package ch08.sec10.exam01;

public class PromotionExample {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a;
		
		a = b;
		D temp1 = (D) a; // 자식 타입으로 강제 형변환도 되네...
		a = c;
		a = d;
		B temp2 = (B) a; // 부모 타입으로 강제 형변환 되고...
		a = e;
		E temp3 = (E) a; // 원래 타입으로 강제 형변환은 물론 되고...
	}
}
