package org.redquark.techinterviews.microsoft.miscellaneous;

import java.util.Scanner;

/**
 * This class finds out the square root of a given number
 * 
 * @author Anirudh Sharma
 *
 */
public class FindSquareRoot {

	public static void main(String[] args) {

		// Scanner instance to get the inputs from the user
		Scanner in = new Scanner(System.in);
		// Number whose square root we need to find
		int n = in.nextInt();
		// Close the scanner instance to avoid memory leak
		in.close();

		if (n >= 0) {
			System.out.println("Square root of " + n + " is: " + squareRoot(n));
		} else {
			System.out.println("Invalid number");
		}

	}

	private static int squareRoot(int n) {

		// Base condition - if the number is zero or 1
		if (n == 0 || n == 1) {
			return n;
		}

		// Do the binary search for the floor of x
		int start = 1;
		int end = n;
		int answer = 0;

		// Loop until we reach the base condition
		while (start <= end) {
			// Find the mid point
			int mid = start + (end - start) / 2;

			// If x is perfect square
			if (mid * mid == n) {
				return mid;
			}

			// Since we need floor, we update the answer when mid*mid is less than x, and
			// move closer to the square root of x
			if (mid * mid < n) {
				start = mid + 1;
				answer = mid;
			} else {
				// If mid*mid is greater than x
				end = mid - 1;
			}
		}
		return answer;
	}
}
