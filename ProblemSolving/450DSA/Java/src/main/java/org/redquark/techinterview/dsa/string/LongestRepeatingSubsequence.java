package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string str, find length of the longest repeating subseequence such that the two
 * subsequence don’t have same string character at same position, i.e., any i-th character
 * in the two subsequences shouldn’t have the same index in the original string.
 * <p>
 * Constraints:
 * 1 <= |s| <= 500
 */
public class LongestRepeatingSubsequence {

    private static int longestRepeatingSubsequence(String s) {
        // Length of the string
        int n = s.length();
        // DP array
        int[][] dp = new int[n + 1][n + 1];
        // Fill the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        System.out.println(longestRepeatingSubsequence("banana"));
        System.out.println(longestRepeatingSubsequence("abcd"));
        System.out.println(longestRepeatingSubsequence("axxxy"));
        System.out.println(longestRepeatingSubsequence("aab"));
    }
}
