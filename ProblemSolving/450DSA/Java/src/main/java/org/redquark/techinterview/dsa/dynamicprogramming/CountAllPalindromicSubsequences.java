package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s, return the number of different non-empty palindromic subsequences in s.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * A subsequence of a string is obtained by deleting zero or more characters from the string.
 * <p>
 * A sequence is palindromic if it is equal to the sequence reversed.
 * <p>
 * Two sequences a1, a2, ... and b1, b2, ... are different if there is some i for which ai != bi.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s[i] is either 'a', 'b', 'c', or 'd'.
 */
public class CountAllPalindromicSubsequences {

    private static int countPalindromicSubsequences(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // Length of the string
        int n = s.length();
        // Lookup table to store the palindromic susequences
        int[][] lookup = new int[n][n];
        // Populate the lookup table for strings of length 1
        for (int i = 0; i < n; i++) {
            lookup[i][i] = 1;
        }
        // Populate for other combinations
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int k = i + j - 1;
                // If extreme characters are same
                if (s.charAt(j) == s.charAt(k)) {
                    lookup[j][k] = lookup[j + 1][k] + lookup[j][k - 1] + 1;
                } else {
                    lookup[j][k] = lookup[j + 1][k] + lookup[j][k - 1] - lookup[j + 1][k - 1];
                }
            }
        }
        return lookup[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "abcb";
        System.out.println(countPalindromicSubsequences(s));

        s = "abcd";
        System.out.println(countPalindromicSubsequences(s));

        s = "aaaa";
        System.out.println(countPalindromicSubsequences(s));
    }
}
