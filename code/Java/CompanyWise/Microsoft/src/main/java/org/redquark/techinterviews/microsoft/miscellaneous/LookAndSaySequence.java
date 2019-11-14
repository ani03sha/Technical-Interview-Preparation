package org.redquark.techinterviews.microsoft.miscellaneous;

import java.util.Scanner;

/**
 * Given a pattern as below and an integer n your task is to decode it and print
 * nth row of it.
 * 
 * The pattern follows as : 1 11 21 1211 111221...
 * 
 * @author Anirudh Sharma
 *
 */
public class LookAndSaySequence {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// Read the numbers of terms to be generated
		int n = in.nextInt();
		// Close the scanner to avoid memory leak
		in.close();

		System.out.println(generatePattern(n));
	}

	/**
	 * This method will generate the Look and Say pattern
	 */
	private static String generatePattern(int n) {

		// Base cases
		if (n == 1) {
			return "1";
		}

		if (n == 2) {
			return "11";
		}

		// Previous term
		String previous = "11";

		// Now we are going to find the rest of the terms from 3 to n. Every term will
		// be generated using the previous term
		for (int i = 3; i <= n; i++) {
			// In below for loop, previous character is processed in current iteration. That
			// is why a dummy character is added to make sure that loop runs one extra
			// iteration.
			previous += '$';

			// Length of the previous String
			int length = previous.length();

			// Count of consecutively matching characters
			int count = 1;

			// i'th term in the series
			String temp = "";

			char[] chars = previous.toCharArray();

			// Process previous term to find the next term
			for (int j = 1; j < length; j++) {
				// If the consecutive characters do not match
				if (chars[j] != chars[j - 1]) {
					// Append count of previous[j-1] to the temp
					temp += count + 0;

					// Append previous[j-1]
					temp += chars[j - 1];

					// Reset the count to 1
					count = 1;
				} else {
					// If matches then increment the count
					count++;
				}
			}

			// Update the previous
			previous = temp;
		}

		return previous;
	}
}
