package org.redquark.techinterviews.microsoft.miscellaneous;

import java.util.Scanner;

/**
 * Given a number having only one ‘1’ and all other ’0’s in its binary
 * representation, find position of the only set bit. If there is only one '1'
 * bit then print that position else print -1. Position of set bit '1' should be
 * counted starting with 1 from LSB side in binary representation of the number.
 * 
 * @author Anirudh Sharma
 *
 */
public class PositionOfOnlySetBit {

	public static void main(String[] args) {

		// Scanner instance to read inputs from the user
		Scanner in = new Scanner(System.in);
		// Number to work upon
		int n = in.nextInt();
		// Closing the scanner to avoid memory leak
		in.close();

		System.out.println("Position of only set bit: " + findPosition(n));
	}

	/**
	 * This method returns the position of the only set bit
	 */
	private static int findPosition(int n) {

		// Getting the log2 value for the n.
		// If number is power of two then and then only its binary representation
		// contains only one ‘1’. That’s why check whether the given number is a power
		// of 2 or not. If given number is not a power of 2, then print error message
		// and exit.
		double logValue = Math.log(n) / Math.log(2);

		// Check if the logValue is an integral value. If it a floating point number
		// then it cannot be a perfect power of 2.
		if (logValue == Math.floor(logValue) && !Double.isInfinite(logValue)) {
			// Return the position of the set bit ('1')
			return (int) (logValue + 1);
		}

		// Number may have more than one set bits
		return -1;

	}
}
