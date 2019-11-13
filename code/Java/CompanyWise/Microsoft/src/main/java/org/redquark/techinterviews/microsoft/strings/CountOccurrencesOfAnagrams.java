package org.redquark.techinterviews.microsoft.strings;

import java.util.Scanner;

/**
 * Given a word and a text, return the count of the occurrences of anagrams of
 * the word in the text.
 * 
 * @author Anirudh Sharma
 *
 */
public class CountOccurrencesOfAnagrams {

	public static void main(String[] args) {

		// Scanner instance to read inputs from the user
		Scanner in = new Scanner(System.in);
		// Text to be searched in
		String text = in.next();
		// Pattern to be searched
		String pattern = in.next();
		// Close the scanner to avoid memory loss
		in.close();

		// Search the pattern
		System.out.println("Total occurrences of Anagrams: " + countOccurrencesOfAnagrams(text, pattern));

	}

	/**
	 * This method returns the count of the Anagrams of a pattern in a given text
	 */
	private static int countOccurrencesOfAnagrams(String text, String pattern) {

		// Total number of ASCII characters
		int MAX = 256;

		// Length of the text
		int n = text.length();
		// Length of the pattern
		int m = pattern.length();

		// Count of the occurrences of Anagrams
		int count = 0;

		// Array to store frequencies of characters in a window of text
		char[] countTW = new char[MAX];
		// Array to store frequencies of characters in the pattern
		char[] countP = new char[MAX];

		// Store the frequencies of characters of pattern and the first window of text
		for (int i = 0; i < m; i++) {
			(countP[pattern.charAt(i)])++;
			(countTW[text.charAt(i)])++;
		}

		// Traverse through the remaining characters of the text
		for (int i = m; i < n; i++) {

			// Compare the frequencies of current window's characters and the pattern's
			// characters
			if (compareArrays(countP, countTW)) {
				count++;
			}

			// Add current (trailing) character to the current window
			countTW[text.charAt(i)]++;

			// Remove trailing character from the current window
			countTW[text.charAt(i - m)]--;
		}

		// Check for the last window in the text
		if (compareArrays(countP, countTW)) {
			count++;
		}

		return count;
	}

	/**
	 * This method checks if the current window array and the pattern array are
	 * equal or not
	 */
	private static boolean compareArrays(char[] a, char[] b) {
		for (int i = 0; i < 256; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
}
