package sortingTool;

import java.util.Scanner;

public class Main {
	final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int max = Integer.parseInt(sc.next().trim());
		int totalNbr = 1, z =1;
		
		while(sc.hasNext()) {
			int nbr = Integer.parseInt(sc.next().trim());
			totalNbr++;
			if(max < nbr) {
				max = nbr;
				z = 1;
			}
			else if(max == nbr)
				z++;
        }
		System.out.printf("Total numbers: %d.\n", totalNbr);
		System.out.printf("The largest number: %d (%d time(s)).", max, z);
	}
}
