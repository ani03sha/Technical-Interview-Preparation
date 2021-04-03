package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some
 * characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * Constraints:
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */
public class LongestCommonSubsequence {

    private static int longestCommonSubsequence(String text1, String text2) {
        // Lengths of the strings
        int m = text1.length();
        int n = text2.length();
        // DP array
        int[][] dp = new int[m + 1][n + 1];
        // Loop through the texts
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Check if characters are same
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));

        text1 = "abc";
        text2 = "abc";
        System.out.println(longestCommonSubsequence(text1, text2));

        text1 = "abc";
        text2 = "def";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
