package sortingTool;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	final static Scanner sc = new Scanner(System.in);
	static ArrayList<String> arr = new ArrayList<String>();
	
	public static void main(String[] args) {
		if(args[0].equals("-dataType"))
		switch (args[1]) {
		case "word":
			wordData();
			break;
		case "line":
			lineData();
			break;
		case "long":
			longData();
			break;
		}		
	}
	
	static void wordData() {
		while(sc.hasNext()) {
			arr.add(sc.next().trim());
        }
		int max = 0;
		for (int i = 1; i < arr.size(); i++) {
			if(arr.get(i).length() > arr.get(max).length()) 
				max = i;
			else if(arr.get(i).length() == arr.get(max).length()) {
				if(arr.get(i).compareTo(arr.get(max)) < 0)
					max = i;
			}
		}
		int occ = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).equals(arr.get(max)))
				occ++;
		}
		System.out.printf("Total words: %d.\n", arr.size());
		System.out.println("The longest word: " + arr.get(max) + " (" + occ + " time(s), " + ((occ*100)/arr.size()) + "%).");
	}
	static void lineData() {
		while(sc.hasNext()) {
			arr.add(sc.nextLine().trim());
        }
		int max = 0;
		for (int i = 1; i < arr.size(); i++) {
			if(arr.get(i).length() > arr.get(max).length()) 
				max = i;
			else if(arr.get(i).length() == arr.get(max).length()) {
				if(arr.get(i).compareTo(arr.get(max)) < 0)
					max = i;
			}
		}
		int occ = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i).equals(arr.get(max)))
				occ++;
		}
		System.out.printf("Total words: %d.\n", arr.size());
		System.out.println("The longest line:\n" + arr.get(max) + "\n(" + occ + " time(s), " + ((occ*100)/arr.size()) + "%).");
	}
	static void longData() {
		while(sc.hasNext()) {
			arr.add(sc.next().trim());
        }
		int max = 0, occ = 1;
		for (int i = 0; i < arr.size(); i++) {
			if(Integer.valueOf(arr.get(i)) > Integer.valueOf(arr.get(max))) {
				max = i;
				occ = 1;
			}
			else if(Integer.valueOf(arr.get(i)) == Integer.valueOf(arr.get(max)))
				occ++;
		}
		System.out.printf("Total numbers: %d.\n", arr.size());
		System.out.println("The largest number: " + arr.get(max) + " (" + occ + " time(s), " + ((occ*100)/arr.size()) + "%).");
	}
}
