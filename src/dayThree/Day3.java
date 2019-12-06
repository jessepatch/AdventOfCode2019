package dayThree;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day3 {

	static String fileName = "C:\\Users\\P2869731\\Documents\\AOC\\inputDay3.txt";

	static int wireArea = 8000;

	public static void main(String[] args) {
		parseInput();
	}

	public static void parseInput() {

		Scanner scanner = null;

		ArrayList<String> wireOne = new ArrayList<String>();

		ArrayList<String> wireTwo = new ArrayList<String>();

		try {

			scanner = new Scanner(new File(fileName));

		} catch (FileNotFoundException ex) {

		}

		int[][] wire = new int[wireArea][wireArea];

		String[] wireOneDirections = scanner.next().split(",");

		for (int x = 0; x < wireOneDirections.length; x++) {
			wireOne.add(wireOneDirections[x]);
		}

		// int[][] wireOneMap = makeWireMap(wireOneDirections, wire, 1);

		int[][] wireOneMapPart2 = makeWireMapPart2(wireOneDirections, wire, true);

		String[] wireTwoDirections = scanner.next().split(",");

		for (int x = 0; x < wireTwoDirections.length; x++) {
			wireTwo.add(wireTwoDirections[x]);
		}

		// int[][] wireTwoMap = makeWireMap(wireTwoDirections, wire, 4);

		makeWireMapPart2(wireTwoDirections, wire, false);

		findClosestToCenter(wire);
		findSmallestDistance(wire);
	}
	
	public static void findClosestToCenter(int[][] wiresCombined) {
		ArrayList<Point> overlaps = new ArrayList<Point>();

        for(int x = 0; x < wireArea; x++) {
              for(int y = 0; y < wireArea; y++) {
                     if(wiresCombined[x][y] == 5) {
                            System.out.println("here");
                            overlaps.add(new Point(x,y));
                     }
              }
        }

        System.out.println("Overlaps size= " + overlaps.size());

        ArrayList<Integer> taxicabDistances = new ArrayList<Integer>();

        for(int x = 0; x < overlaps.size(); x++) {
              taxicabDistances.add(Math.abs(overlaps.get(x).x - (wireArea/2)) + Math.abs(overlaps.get(x).y - (wireArea/2)));
        }

        System.out.println(taxicabDistances.size());
        System.out.println(Collections.min(taxicabDistances));
	}
	
	public static void findSmallestDistance(int[][] combinedWires) {
		ArrayList<Integer> overlapsDistance = new ArrayList<Integer>();

		for (int x = 0; x < wireArea; x++) {
			for (int y = 0; y < wireArea; y++) {
				if (combinedWires[x][y] < 0) {
					overlapsDistance.add(combinedWires[x][y]);
				}
			}
		}

		System.out.println(overlapsDistance.size());
		System.out.println(Collections.max(overlapsDistance));
	}

	public static int[][] makeWireMap(String[] wireDirections, int[][] wire, int amountToAdd) {

		int x = wireArea / 2;
		int y = wireArea / 2;

		for (int z = 0; z < wireDirections.length; z++) {

			String direction = wireDirections[z].substring(0, 1);

			int distance = Integer.parseInt(wireDirections[z].substring(1));

			switch (direction) {
			case "L":
				for (int a = 0; a < distance; a++) {
					x = x - 1;
					checkSameWireOverlapAndAddWire(wire, x, y, amountToAdd);
				}
				break;
			case "R":
				for (int b = 0; b < distance; b++) {
					x = x + 1;
					checkSameWireOverlapAndAddWire(wire, x, y, amountToAdd);
				}
				break;
			case "U":
				for (int c = 0; c < distance; c++) {
					y = y + 1;
					checkSameWireOverlapAndAddWire(wire, x, y, amountToAdd);
				}
				break;
			case "D":
				for (int d = 0; d < distance; d++) {
					y = y - 1;
					checkSameWireOverlapAndAddWire(wire, x, y, amountToAdd);
				}
				break;
			}
		}
		return wire;
	}

	public static void checkSameWireOverlapAndAddWire(int[][] wire, int x, int y, int amountToAdd) {

		if (y > 0 && x > 0 && x < wireArea && y < wireArea) {
			wire[x][y] = wire[x][y] + amountToAdd;
		}
	}

	// Part 2
	public static int[][] makeWireMapPart2(String[] wireDirections, int[][] wire, boolean isFirstTime) {


              int x = wireArea/2;

              int y = wireArea/2;

              int runningTotal = 0;
             
              for(int z = 0; z < wireDirections.length; z++) {

                     String direction = wireDirections[z].substring(0, 1);

                     int distance = Integer.parseInt(wireDirections[z].substring(1));

                     switch(direction) {
                           case "L":
                                  for(int a = 0; a < distance; a++) {
                                         x = x - 1;
                                         checkSameWireOverlapAndAddWirePart2(wire, x, y, ++runningTotal, isFirstTime);   
                                  }
                                  break;
                           case "R":
                                  for(int b = 0; b < distance; b++) {
                                         x = x + 1;
                                         checkSameWireOverlapAndAddWirePart2(wire, x, y, ++runningTotal, isFirstTime);   
                                  }
                                  break;
                           case "U":
                                  for(int c = 0; c < distance; c++) {
                                         y = y + 1;
                                         checkSameWireOverlapAndAddWirePart2(wire, x, y, ++runningTotal, isFirstTime);   
                                  }
                                  break;
                           case "D":
                                  for(int d = 0; d < distance; d++) {
                                         y = y - 1;
                                         checkSameWireOverlapAndAddWirePart2(wire, x, y, ++runningTotal, isFirstTime);   
                                  }
                                  break;
                     }              
              }
              return wire;
       }

	public static void checkSameWireOverlapAndAddWirePart2(int[][] wire, int x, int y, int runningTotal, boolean isFirstTime) {

              if(y > 0 && x > 0 &&  x < wireArea && y < wireArea && isFirstTime) {
                     wire[x][y] = runningTotal;
              }

              else if(y > 0 && x > 0 && x < wireArea && y < wireArea && !isFirstTime && wire[x][y] > 0) {
                     wire[x][y] = (wire[x][y] * -1) - runningTotal;
              }
	}
}
