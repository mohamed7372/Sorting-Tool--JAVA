package sortingTool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	final static Scanner sc = new Scanner(System.in);
	static ArrayList<String> arr = new ArrayList<String>();
	static HashMap<String, String> values = new HashMap<String, String>(); 
	
	public static void main(String[] args) {
		String[] input = {"", "", "", ""};
		for (int i = 0; i < args.length; i++) {
			if(args[i].equals("-sortingType")) {
				input[0] = "sorting";
				if(++i < args.length)
					input[1] = args[i];
			}
			else if(args[i].equals("-dataType")) {
				input[2] = "data";
				if(++i < args.length)
					input[3] = args[i];
			}
			else if(args[i].charAt(0) == '-') 
				System.out.println("\"" + args[i] + "\" isn't a valid parameter. It's skipped.");
		}
		
		if(!input[0].isEmpty() && input[1].isEmpty())
			System.out.println("No sorting type defined!");
		else if(!input[2].isEmpty() && input[3].isEmpty())
			System.out.println("No data type defined!");
		else if(!input[2].isEmpty() && !input[3].isEmpty())
			traitement(input);
	}
	
	static void traitement(String[] args) {
		switch (args[3]) {
		case "word":
			if(!args[1].isEmpty())
				wordData(args[1]);
			else 
				wordData("natural");
			break;
		case "line":
			if(!args[1].isEmpty())
				lineData(args[1]);
			else 
				lineData("natural");
			break;
		case "long":
			if(!args[1].isEmpty())
				longData(args[1]);
			else 
				longData("natural");
			break;
		}
	}
	
	static void wordData(String sortingType) {
		while(sc.hasNext()) {
			arr.add(sc.next().trim());
        }
		System.out.printf("Total words: %d.\n", arr.size());
		if(sortingType.equals("byCount"))
			byCount("string");
		else if(sortingType.equals("natural"))
			natural("word");
	}
	static void lineData(String sortingType) {
		while(sc.hasNext()) {
			arr.add(sc.nextLine().trim());
        }
		System.out.printf("Total lines: %d.\n", arr.size());
		if(sortingType.equals("byCount"))
			byCount("string");
		else if(sortingType.equals("natural"))
			natural("line");
	}
	static void longData(String sortingType) {
		while(sc.hasNext()) {
			arr.add(sc.next().trim());
        }
		if(sortingType.equals("byCount")) {
			System.out.printf("Total numbers: %d.\n", arr.size());
			byCount("long");
		}
		else if(sortingType.equals("natural"))
			natural("long");
	}

	static void byCount(String type) {
		for (int i = 0; i < arr.size(); i++) {
			if(!values.containsKey(arr.get(i))) {
				int occ = 0;
				for (String string : arr)
					occ = arr.get(i).equals(string) ? occ + 1 : occ + 0;
				values.put(arr.get(i), String.valueOf(occ));
			}
		}
		if(type.equals("string")) {
			ArrayList<String> keys = new ArrayList<String>();
			for (String name : values.keySet()) 
				keys.add(name);	
			// sort donne
			Collections.sort(keys);
			String[] tab = new String[keys.size()];
			for (int i = 0; i < tab.length; i++) 
				tab[i] = keys.get(i);
			for (int i = 0; i < tab.length-1; i++) {
				for (int j = i+1; j < tab.length; j++) {
					if(Integer.valueOf(values.get(tab[i])) > Integer.valueOf(values.get(tab[j]))) {
						String c = tab[i];
						tab[i] = tab[j];
						tab[j] = c;
					}
				}
			}
			for (String i : tab) { 
				double d = (Double.valueOf(values.get(i))*100.0)/arr.size();
				double res = Math.round(d);
			    System.out.println(i + ": " + values.get(i) + " time(s), " + (int)res + "%).");
			}
		}
		else {
			ArrayList<Integer> keys = new ArrayList<Integer>();
			for (String name : values.keySet()) 
				keys.add(Integer.valueOf(name));
			// sort donne
			Collections.sort(keys);
			int[] tab = new int[keys.size()];
			for (int i = 0; i < tab.length; i++) 
				tab[i] = keys.get(i);
			for (int i = 0; i < tab.length-1; i++) {
				for (int j = i+1; j < tab.length; j++) {
					if(Integer.valueOf(values.get(tab[i]+"")) > Integer.valueOf(values.get(tab[j]+""))) {
						int c = tab[i];
						tab[i] = tab[j];
						tab[j] = c;
					}
				}
			}
			for (int i : tab) { 
				double d = (Double.valueOf(values.get(i+""))*100.0)/arr.size();
				double res = Math.round(d);
			    System.out.println(i + ": " + values.get(i+"") + " time(s), " + (int)res + "%).");
			}
		}
	}
	static void natural(String typeData) {
		if(typeData.equals("long")) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (int i = 0; i < arr.size(); i++) { 
				if(arr.get(i).matches("[-]{0,1}\\d+"))
					ar.add(Integer.valueOf(arr.get(i)));
				else
					System.out.println("\"" + arr.get(i) + "\" isn't a long. It's skipped.");
			}
			System.out.printf("Total numbers: %d.\n", ar.size());
			System.out.print("Sorted data: ");
			Collections.sort(ar);
			for (Integer integer : ar) 
				System.out.print(integer + " ");
		}
		else if(typeData.equals("line")){
			System.out.print("Sorted data: ");
			System.out.println();
			Collections.sort(arr);
			for (String str : arr) 
				System.out.println(str);
		}
		else {
			System.out.print("Sorted data: ");
			Collections.sort(arr);
			for (String str : arr) 
				System.out.print(str + " ");
		}
	}
}
