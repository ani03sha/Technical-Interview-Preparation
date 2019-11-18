package org.redquark.techinterviews.microsoft.miscellaneous;

import java.util.Scanner;

/**
 * The problem is to count all the possible paths from top left to bottom right
 * of a mXn matrix with the constraints that from each cell you can either move
 * only to right or down
 * 
 * @author Anirudh Sharma
 *
 */
public class CountPossiblePathsInMatrix {

	public static void main(String[] args) {

		// Scanner instance to read inputs from the user
		Scanner in = new Scanner(System.in);
		// Read number of rows in a matrix
		int row = in.nextInt();
		// Read number of columns in a matrix
		int column = in.nextInt();
		// Close Scanner to avoid memory leak
		in.close();

		System.out.println("Total number of paths: " + countPaths(row, column));
	}

	/**
	 * This method returns the count of paths to reach cell at row m and column n
	 * from the topmost left cell
	 */
	private static int countPaths(int row, int column) {

		// Create an array to store results of subproblems
		int[] dp = new int[column];

		// Initialize the first element
		dp[0] = 1;

		for (int i = 0; i < row; i++) {
			for (int j = 1; j < column; j++) {
				dp[j] += dp[j - 1];
			}
		}

		return dp[column - 1];
	}

}
