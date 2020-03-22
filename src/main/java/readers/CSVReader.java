package readers;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CSVReader implements ReaderInterface {

	private List<String[]> text = new ArrayList<String[]>();	
	private boolean active = false;
	
	public void read(String location) {
		try {
			Path path = Paths.get(location);
			Stream<String> stream = Files.lines(path);
			for(Object line: stream.toArray()) {
				String[] lines = ((String)line).split(","); 
				text.add(lines);
			}
			active = true;
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void print() {
		if(active) {
			for(String[] line: text) {
				for(String l: line) {
					System.out.println(l);
				}
			}
		} else {
			System.out.println("No file instantiated");
		}

	}

	public void save(String location) {
		if(active) {
			Path path = Paths.get(location);
			try {
				BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
				for(String[] line: text) {
					bufferedWriter.append(String.join(",", line) + "\n");
				}
				bufferedWriter.flush();
				bufferedWriter.close();
				System.out.println("New file written to: " + location);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No file instantiated");
		}
	}

}
