package org.redquark.techinterviews.adobe;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class Adobe004_SetBits {

	/**
	 * This method returns the total number of set bits in an integer using Brian
	 * Kernighan’s Algorithm
	 */
	private static int countSetBits(int n) {

		// This variable will store the total number of set bits in an integer
		int count = 0;

		// Loop until the value of n is greater than 0
		while (n > 0) {
			// Bitwise "&" with n-1 and self
			n &= (n - 1);
			// Increment the count by 1
			count++;
		}
		return count;
	}

	public static void main(String[] args) {

		// Scanner variable to read input from the user
		Scanner in = new Scanner(System.in);
		// Read integer from the user
		int n = in.nextInt();
		// Close the scanner to avoid memory leak
		in.close();

		System.out.println("Number of set bits in " + n + " is/are: " + countSetBits(n));
	}
}
