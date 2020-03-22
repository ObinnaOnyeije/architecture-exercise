package readers;

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
			System.out.println("No input instantiated");
		}

	}

	public void save() {
		// TODO Auto-generated method stub

	}

}
