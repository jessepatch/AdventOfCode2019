package dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
	
	static String fileName = "D:\\Windows\\Documents\\AdventOfCode2019\\day1input.txt";

	public static void main(String[] args) {
		ArrayList<Integer> modulesMasses = parseInput();
		System.out.println(findTotalFuel(modulesMasses, 0));
	}
	
	public static ArrayList<Integer> parseInput() {
		
	
	Scanner scanner = null;
	ArrayList<Integer> modulesMasses = new ArrayList<Integer>();

	
	try {
		scanner = new Scanner(new File(fileName));
		
	 } catch (FileNotFoundException ex) {
	 }
	
	while(scanner.hasNext()) {
		modulesMasses.add(Integer.parseInt(scanner.next()));
	}
	
	
	
	return modulesMasses;

	}
	
	public static int findTotalFuel(ArrayList<Integer> modulesMasses, int previousTotalMass) {
		
		int totalFuel = 0;
		ArrayList<Integer> newFuelMasses = new ArrayList<Integer>();

		for(int x = 0; x < modulesMasses.size(); x++) {
			if(findMassRequired(modulesMasses.get(x)) > 0) {
				newFuelMasses.add(findMassRequired(modulesMasses.get(x)));
			}
			totalFuel = totalFuel +	findMassRequired(modulesMasses.get(x));
		}
		totalFuel = totalFuel + previousTotalMass;
		System.out.println(newFuelMasses.size());
		System.out.println(totalFuel);
		if(newFuelMasses.size() > 0) {
			findTotalFuel(newFuelMasses, totalFuel);
		}
		return totalFuel;
	}
	
	public static int findMassRequired(int mass) {
		int y = (int) Math.floor(mass / 3);
		int z = y - 2;
		
		if(z < 0) {
			return 0;
		}
		return z;
	}
	
	
}
