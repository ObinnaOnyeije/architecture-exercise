package architectureExercise;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;
import readers.*;

public class FileConstructor {
	
	private static final Pattern reg_num = Pattern.compile("-?\\d+(\\.\\d+)?");
	private static Scanner scan;
	
	private static CSVReader r_csv;
	private static InputReader r_inp;
	private static TextReader r_txt;
	
	private static final String separator = FileSystems.getDefault().getSeparator();
	private static Path basePath = Paths.get("").toAbsolutePath();
	private static String resourcePath = "src" + separator + "main" + separator + "resources" + separator;
	private static Path csvPath = basePath.resolve(resourcePath + "PracticeFile.csv");
	private static Path txtPath = basePath.resolve(resourcePath + "PracticeFile.txt");

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String menuOption = "";
		
		System.out.println("Select a file option");
		System.out.println("0: Exit program");
		System.out.println("1: CSVReader");
		System.out.println("2: InputReader");
		System.out.println("3: TextReader");
		System.out.print("Enter:");
		
		menuOption = scan.nextLine();
		
		while(true) {
			if(isNumeric(menuOption)) {
				int option = Integer.parseInt(menuOption);
				if((option > 0) && (option < 4)) {
					readerOptions(option);
				} else if (option == 0) {
					break;
				} else {
					System.out.println("No option selected.");
				}
			} else {
				System.out.println("Incorrect option format");
			}
			System.out.println("Select a file option");
			System.out.println("0: Exit program");
			System.out.println("1: CSVReader");
			System.out.println("2: InputReader");
			System.out.println("3: TextReader");
			System.out.print("Enter:");
			menuOption = scan.nextLine();
		}
		
	}
	
	private static void readerOptions(int value) {
		String command = "";
		System.out.println("Select a file option");
		System.out.println("0: Exit this file");
		System.out.println("1: Read");
		System.out.println("2: Print");
		System.out.println("3: Save");
		System.out.print("Enter:");
		
		command = scan.nextLine();
		
		int opt;
		
		while(true) {
			if(isNumeric(command)) {
				opt = Integer.parseInt(command);
				if((opt > 0) && (opt < 4)) {
					switch(value) {
					case 1:
						if(r_csv == null) {
							r_csv = new CSVReader();
						}
						switch(opt) {
						case 1:
							r_csv.read(csvPath.toString());
							break;
						case 2:
							r_csv.print();
							break;
						case 3:
							r_csv.save();
							break;
						}
						break;
					case 2:
						if(r_inp == null) {
							r_inp = new InputReader();
						}
						switch(opt) {
						case 1:
							r_inp.read("");
							break;
						case 2:
							r_inp.print();
							break;
						case 3:
							r_inp.save();
							break;
						}
						break;
					case 3:
						if(r_txt == null) {
							r_txt = new TextReader();
						}
						switch(opt) {
						case 1:
							r_txt.read(txtPath.toString());
							break;
						case 2:
							r_txt.print();
							break;
						case 3:
							r_txt.save();
							break;
						}
						break;
					}
				} else if (opt == 0) {
					return;
				} else {
					System.out.println("No option selected.");
				}
			} else {
				System.out.println("Incorrect option format");
			}
			System.out.println("Select a file option");
			System.out.println("0: Exit this file");
			System.out.println("1: Read");
			System.out.println("2: Print");
			System.out.println("3: Save");
			System.out.print("Enter:");
			command = scan.nextLine();
		}
		
	}
	
	private static boolean isNumeric(String str_num) {
		if(str_num==null||str_num.contentEquals("")) {
			return false;
		} else {
			return reg_num.matcher(str_num).matches();
		}
	}

}
