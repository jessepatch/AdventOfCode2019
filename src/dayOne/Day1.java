package dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
	
	static String fileName = "D:\\Windows\\Documents\\AdventOfCode2019\\day1input.txt";

	public static void main(String[] args) {
		findTotalFuel();
	}
	
	public static String findTotalFuel() {
		
	
	Scanner scanner = null;
	ArrayList<Integer> modulesMasses = new ArrayList<Integer>();
	int totalFuel = 0;

	
	try {
		scanner = new Scanner(new File(fileName));
		
	 } catch (FileNotFoundException ex) {
	 }
	
	while(scanner.hasNext()) {
		modulesMasses.add(Integer.parseInt(scanner.next()));
	}
	
	for(int x = 0; x < modulesMasses.size(); x++) {
		int y = (int) Math.floor(modulesMasses.get(x) / 3);
		int z = y - 2;
		totalFuel = totalFuel + z;
	}
	System.out.println(totalFuel);
	return "Total fuel =" + totalFuel;

	}
}
