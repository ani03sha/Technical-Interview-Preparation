package org.redquark.techinterviews.microsoft.arrays;

/**
 * Given a struct array of type Height, having two elements feet and inches.
 * Find the maximum height, where height is calculated sum of feet and inches
 * after converting feet into inches.
 * 
 * @author Anirudh Sharma
 *
 */
public class MaximumInStructArray {

	/**
	 * This class (struct) represents the Height whose members are given as feet and
	 * inches
	 */
	private static class Height {

		// Feet part of the height
		private int feet;
		// Inches part of the height
		private int inches;

		/**
		 * A constructor to create one instance of height
		 */
		Height(int feet, int inches) {
			this.feet = feet;
			this.inches = inches;
		}
	}

	/**
	 * This method finds the maximum height in an array of heights
	 */
	private static int findMaxHeight(Height[] heights) {

		// Maximum value
		int max = Integer.MIN_VALUE;

		// Loop through all the elements in the array
		for (int i = 0; i < heights.length; i++) {
			// Get the total height in inches
			int temp = 12 * heights[i].feet + heights[i].inches;
			// Assign max to the maximum of current height and the previous max
			max = Math.max(temp, max);
		}

		// Return the final maximum height
		return max;
	}

	public static void main(String[] args) {

		// Array of heights
		Height[] heights = { new Height(1, 3), new Height(10, 5), new Height(6, 8), new Height(3, 7),
				new Height(5, 9) };

		System.out.println("Maximum height in inches: " + findMaxHeight(heights));
	}

}
