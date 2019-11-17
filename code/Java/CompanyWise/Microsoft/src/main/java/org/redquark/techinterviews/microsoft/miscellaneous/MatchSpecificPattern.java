package org.redquark.techinterviews.microsoft.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a dictionary of words, find all strings that matches the given pattern
 * where every character in the pattern is uniquely mapped to a character in the
 * dictionary.
 * 
 * @author Anirudh Sharma
 *
 */
public class MatchSpecificPattern {

	public static void main(String[] args) {

		String[] dictionary = { "abb", "abc", "xyz", "xyy" };
		String pattern = "foo";

		findMatchingPattern(dictionary, pattern);
	}

	/**
	 * Function to print all the strings that match the given pattern where every
	 * character in the pattern is uniquely mapped to a character in the dictionary
	 */
	private static void findMatchingPattern(String[] dictionary, String pattern) {

		// Iterate for each word in the dictionary
		for (String word : dictionary) {
			if (word.length() == pattern.length() && encode(pattern).equals(encode(word))) {
				System.out.print(word + " ");
			}
		}
	}

	/**
	 * This method will encode the given string
	 */
	private static String encode(String s) {

		// HashMap to map the character of a string with an integer
		Map<Character, Integer> encoder = new HashMap<>();

		// This will store the resultant encoded string for the given string
		String result = null;

		// This will be the encoded value of a character
		int x = 0;

		// Loop for each character in the given string
		for (int i = 0; i < s.length(); i++) {
			// Current character
			char c = s.charAt(i);
			// Check if the character is already present in a map
			if (!encoder.containsKey(c)) {
				// If the character is occurring for the first time, assign next unique number
				// to that char
				encoder.put(c, x++);
			}
			// Append all the encoded string values to the result. This will give us the
			// completely hashed encoded string for the given string
			result += encoder.get(c);
		}
		return result;
	}
}
