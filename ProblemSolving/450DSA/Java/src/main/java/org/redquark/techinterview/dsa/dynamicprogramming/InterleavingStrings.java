package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * <p>
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty
 * substrings such that:
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * <p>
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * <p>
 * Note: a + b is the concatenation of strings a and b.
 */
public class InterleavingStrings {

    private static boolean isInterleave(String s1, String s2, String s3) {
        // Special case
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        // Lengths of the strings
        int m = s1.length();
        int n = s2.length();
        // Special case
        if (m + n != s3.length()) {
            return false;
        }
        // Lookup table to store if the substrings ending
        // at i and j are interleaved or not
        boolean[][] lookup = new boolean[m + 1][n + 1];
        // Populate the lookup table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    lookup[i][j] = true;
                } else if (i == 0) {
                    if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                        lookup[i][j] = lookup[i][j - 1];
                    }
                } else if (j == 0) {
                    if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                        lookup[i][j] = lookup[i - 1][j];
                    }
                } else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j - 1)) {
                    lookup[i][j] = lookup[i - 1][j];
                } else if (s1.charAt(i - 1) != s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    lookup[i][j] = lookup[i][j - 1];
                } else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    lookup[i][j] = lookup[i - 1][j] || lookup[i][j - 1];
                }
            }
        }
        return lookup[m][n];
    }

    public static void main(String[] args) {
        String s1 = "YX";
        String s2 = "X";
        String s3 = "XXY";
        System.out.println(isInterleave(s1, s2, s3));

        s1 = "XY";
        s2 = "X";
        s3 = "XXY";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
