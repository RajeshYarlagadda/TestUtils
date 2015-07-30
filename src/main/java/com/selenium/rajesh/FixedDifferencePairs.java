package com.selenium.rajesh;

import java.util.Scanner;

public class FixedDifferencePairs {

	public static void main(String[] args) {
		System.out.println("Enter the number of integers and difference:");
		Scanner scanner = new Scanner(System.in);
		int noofIntegers = scanner.nextInt();
		int difference = scanner.nextInt();

		System.out.println("Enter the "+noofIntegers+"  of integers :");
		int[] integers = new int[noofIntegers];
		for(int i = 0;i<noofIntegers;i++){
			integers[i] = scanner.nextInt();
		}
		int count = new FixedDifferencePairs().findPair(integers, integers.length, difference);
		System.out.println("number of pairs "+count);
	}
	
	int findPair(int arr[], int size, int n){
		int counter = 0;
	    for(int i =0;i<size;i++){
	    	for(int j=1;j<size;j++){
	    		if(arr[j]-arr[i]==n){
	    			System.out.println("Pair Found:  ("+ arr[i]+","+arr[j]+")");
	    			counter++;
	    		}
	    	}
	    }
	    return counter;
	}
}
