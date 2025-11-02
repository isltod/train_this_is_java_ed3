package ch18.sec10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectInputOutputStreamExample {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Member m1 = new Member("fall", "단풍이");
			Product p1 = new Product("노트북", 1500000);
			int[] arr = {1, 2, 3};
			oos.writeObject(m1);
			oos.writeObject(p1);
			oos.writeObject(arr);
			oos.flush();
			oos.close();
			
			FileInputStream fis = new FileInputStream("object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Member m2 = (Member) ois.readObject();
			Product p2 = (Product) ois.readObject();
			int[] arr2 = (int[]) ois.readObject();
			ois.close();
			
			System.out.println(m2);
			System.out.println(p2);
			System.out.println(Arrays.toString(arr2));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
