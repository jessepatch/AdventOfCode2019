package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Day2 {

       static String fileName = "C:\\Users\\P2869731\\Documents\\AOC\\inputDay2.txt";

       public static void main(String[] args) {
    	   
    	   int outputTarget = 19690720;
    	   int noun = 0;
    	   int verb = 0;
    	   for(int x = 0; x < 100; x++) {
    		   for(int y = 0; y < 100; y++) {
    			   ArrayList<Integer> program = parseInput();
    		         
    	              program.set(1, x);
    	              program.set(2, y);
    	             
    	              ArrayList<Integer> result = runProgram(program);
    	              System.out.println("Position 0 = " + result.get(0));
    	              if(result.get(0) == outputTarget) {
    	            	  noun = x;
    	            	  verb = y;
    	            	  System.out.println(100 * noun + verb);
    	              }
    		   }
           }
       }
      
       public static ArrayList<Integer> parseInput() {
             
              Scanner scanner = null;
              ArrayList<Integer> intCodeProgram = new ArrayList<Integer>();
             
              try {
            	  scanner = new Scanner(new File(fileName));
              } catch (FileNotFoundException ex) {
              }
             
              while(scanner.hasNext()) {
                     String[] programParts = scanner.next().split(",");
                    
                     for(int x = 0; x < programParts.length; x++) {
                           intCodeProgram.add(Integer.parseInt(programParts[x]));
                     }
              }
              scanner.close();
              return intCodeProgram;
       }
      
       public static ArrayList<Integer> runProgram(ArrayList<Integer> program) {
              int y = 0;
              for(int x = 0; y != 99; x = x + 4) {
                     int operator = program.get(x);
                     if(operator == 1) {
                           program.set(program.get(x+3), program.get(program.get(x+1)) + program.get(program.get(x+2)));
                     }
                     else if(operator == 2) {
                           program.set(program.get(x+3), program.get(program.get(x+1)) * program.get(program.get(x+2)));
                     }
                     else if(operator == 99) {
                           y = 99;
                     }
                     else {
                           System.out.println(operator);
                           System.out.println("Error");
                     }
              }
              return program;
       }
}
