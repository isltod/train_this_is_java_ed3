package ch17.sec04.exam04;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStremExample {
	public static void main(String[] args) {
		try {
			Path path = Paths.get(FileStremExample.class.getResource("data.txt").toURI());
			Stream<String> stream = Files.lines(path, Charset.defaultCharset());
			stream.forEach(line -> System.out.println(line));
			stream.close();
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
