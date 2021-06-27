package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2000
 * s consists of lower-case English letters only.
 */
public class PalindromePartitioning {

    private static int minimumCuts(String s) {
        // Special cases
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // Length of the string
        int n = s.length();
        if (n < 2) {
            return 1;
        }
        // Lookup table to store the partition position
        boolean[][] lookup = new boolean[n][n];
        // Array to store the cuts
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            // Set maximum number of cuts
            cuts[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || lookup[j + 1][i - 1])) {
                    lookup[j][i] = true;
                    if (j > 0) {
                        cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                    } else {
                        cuts[i] = 0;
                    }
                }
            }
        }
        return cuts[n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minimumCuts(s));

        s = "a";
        System.out.println(minimumCuts(s));

        s = "ab";
        System.out.println(minimumCuts(s));
    }
}
