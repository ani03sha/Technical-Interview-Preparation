package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two sequences, find the length of longest subsequence present in both of them.
 * Both the strings are of uppercase.
 */
public class LongestCommonSubsequence {

    private static int lcs(String s1, String s2) {
        // Special case
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return 0;
        }
        // Lengths of the two strings
        int m = s1.length();
        int n = s2.length();
        // Lookup table to store the longest common subsequence
        // for a given value of m and n.
        int[][] lookup = new int[m + 1][n + 1];
        // Populate the table for each character
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If current characters are same
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lookup[i][j] = 1 + lookup[i - 1][j - 1];
                } else {
                    lookup[i][j] = Math.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }
        return lookup[m][n];
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(lcs(s1, s2));

        s1 = "ABC";
        s2 = "AC";
        System.out.println(lcs(s1, s2));
    }
}
