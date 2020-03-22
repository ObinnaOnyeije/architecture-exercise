package readers;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader implements ReaderInterface {

	private List<String> text = new ArrayList<String>();
	private static Scanner scan;
	private boolean active = false;
	
	public void read(String location) {
		String line;
		scan = new Scanner(System.in);
		System.out.println("System now scanning. Enter text.");
		line = scan.nextLine();
		text.add(line);
		System.out.println("System finished scanning.");
		active = true;
	}

	public void print() {
		if(active) {
			for(String line: text) {
				System.out.println(line);
			}
		} else {
			System.out.println("No input instantiated");
		}
	}

	public void save(String location) {
		if(active) {
			Path path = Paths.get(location);
			try {
				BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
				for(String line: text) {
					bufferedWriter.append(line + "\n");
				}
				bufferedWriter.flush();
				bufferedWriter.close();
				System.out.println("New file written to: " + location);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No input instantiated");
		}

	}

}
