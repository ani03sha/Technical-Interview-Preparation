package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s, find length of the longest repeating subseequence such that the two
 * subsequence don’t have same string character at same position, i.e., any i’th character
 * in the two subsequences shouldn’t have the same index in the original string.
 */
public class LongestRepeatingSubsequence {

    private static int longestRepeating(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // Length of the string
        int n = s.length();
        // Lookup table to store the longest repeating
        // subsequence at a certain position
        int[][] lookup = new int[n + 1][n + 1];
        // Populate the table for each distinct character
        // in both strings
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    lookup[i][j] = 1 + lookup[i - 1][j - 1];
                } else {
                    lookup[i][j] = Math.max(lookup[i][j - 1], lookup[i - 1][j]);
                }
            }
        }
        return lookup[n][n];
    }

    public static void main(String[] args) {
        String s = "axxxy";
        System.out.println(longestRepeating(s));

        s = "aab";
        System.out.println(longestRepeating(s));
    }
}
