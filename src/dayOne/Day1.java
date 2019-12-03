package dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
	
	static String fileName = "D:\\Windows\\Documents\\AdventOfCode2019\\day1input.txt";

	public static void main(String[] args) {
		findTotalFuel();
	}
	
	public static void findTotalFuel() {
		
	
	Scanner scanner = null;
	
	try {
		scanner = new Scanner(new File(fileName));
		
	 } catch (FileNotFoundException ex) {
	 }
	
	while(scanner.hasNext()) {
		System.out.println(scanner.next());
	}

	}
}
