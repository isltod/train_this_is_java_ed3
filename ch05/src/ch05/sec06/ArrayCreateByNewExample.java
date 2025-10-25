package ch05.sec06;

public class ArrayCreateByNewExample {
	public static void main(String[] args) {
		int[] arr1 = new int[3];
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1[" + i + "]: " + arr1[i]);
		}
		System.out.println();
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i * 10;
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1[" + i + "]: " + arr1[i]);
		}
		System.out.println();
		double[] arr2 = new double[3];
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("arr2[" + i + "]: " + arr2[i]);
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = i / (double) 10;
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("arr2[" + i + "]: " + arr2[i]);
		}
		System.out.println();
		String[] arr3 = new String[3];
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("arr3[" + i + "]: " + arr3[i]);
		}
		System.out.println();
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = (i+1) + "월";
		}
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("arr3[" + i + "]: " + arr3[i]);
		}
	}
}
