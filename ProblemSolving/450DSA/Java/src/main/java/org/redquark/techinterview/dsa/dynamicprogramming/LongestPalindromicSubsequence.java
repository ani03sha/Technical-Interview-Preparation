package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s, find the longest palindromic subsequence's length in s.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by deleting some
 * or no elements without changing the order of the remaining elements.
 */
public class LongestPalindromicSubsequence {

    private static int longestPalindromeSubsequence(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // Length of the string
        int n = s.length();
        // Lookup table to store the lengths of longest
        // palindromic substrings from string i to j
        int[][] lookup = new int[n][n];
        // Populate the table
        for (int i = n - 1; i >= 0; i--) {
            // Longest palindromic string in a string of
            // length 1 is 1.
            lookup[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                // If characters at both ends are equal
                if (s.charAt(i) == s.charAt(j)) {
                    lookup[i][j] = lookup[i + 1][j - 1] + 2;
                } else {
                    lookup[i][j] = Math.max(lookup[i + 1][j], lookup[i][j - 1]);
                }
            }
        }
        return lookup[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubsequence("bbbab"));
        System.out.println(longestPalindromeSubsequence("cbbd"));

    }
}
