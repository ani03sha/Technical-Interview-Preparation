package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings, find the length of longest subsequence present in both of them.
 * Can we do this in O(n) space
 */
public class SpaceOptimizedLongestCommonSubsequence {

    private static int spaceOptimizedLCS(String s1, String s2) {
        // Special case
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return 0;
        }
        // Lengths of two strings
        int m = s1.length();
        int n = s2.length();
        // Lookup table to store the longest common subsequence
        // for a given value of m and n.
        int[][] lookup = new int[2][n + 1];
        // Binary index used to index current and previous rows
        int binary = 0;
        // Loop over the strings
        for (int i = 1; i <= m; i++) {
            // Current binary index
            binary = i & 1;
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lookup[binary][j] = 1 + lookup[1 - binary][j - 1];
                } else {
                    lookup[binary][j] = Math.max(lookup[1 - binary][j], lookup[binary][j - 1]);
                }
            }
        }
        return lookup[binary][n];
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(spaceOptimizedLCS(s1, s2));

        s1 = "ABC";
        s2 = "AC";
        System.out.println(spaceOptimizedLCS(s1, s2));
    }
}
