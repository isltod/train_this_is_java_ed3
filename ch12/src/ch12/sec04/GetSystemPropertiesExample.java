package ch12.sec04;

import java.util.Properties;
import java.util.Set;

public class GetSystemPropertiesExample {
	public static void main(String[] args) {
		System.out.println("-----------------------");
		System.out.println(" key:      value");
		System.out.println("-----------------------");
		Properties props = System.getProperties();
		Set keys = props.keySet();
		for (Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.printf("%-40s: %s\n", key, value);
		}
	}
}
