package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 */
public class LongestCommonSubstring {

    private static int findLCS(String X, String Y) {
        // Special cases
        if (X == null || X.isEmpty() || Y == null || Y.isEmpty()) {
            return 0;
        }
        // Lengths of the two strings
        int m = X.length();
        int n = Y.length();
        // Lookup table to store the lcs length
        int[][] lookup = new int[m + 1][n + 1];
        // Length of the final lcs
        int lcsLength = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0 && j > 0 && X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = 1 + lookup[i - 1][j - 1];
                    lcsLength = Math.max(lcsLength, lookup[i][j]);
                }
            }
        }
        return lcsLength;
    }

    public static void main(String[] args) {
        String X = "ABCDGH";
        String Y = "ACDGHR";
        System.out.println(findLCS(X, Y));

        X = "ABC";
        Y = "ACB";
        System.out.println(findLCS(X, Y));
    }
}
