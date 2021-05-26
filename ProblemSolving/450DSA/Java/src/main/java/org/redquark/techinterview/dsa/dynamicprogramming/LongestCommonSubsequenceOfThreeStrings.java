package org.redquark.techinterview.dsa.dynamicprogramming;

public class LongestCommonSubsequenceOfThreeStrings {

    private static int lcsOfThreeStrings(String A, String B, String C) {
        // Lengths of the strings
        int a = A.length();
        int b = B.length();
        int c = C.length();
        int[][][] lookup = new int[a + 1][b + 1][c + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1)) {
                        lookup[i][j][k] = 1 + lookup[i - 1][j - 1][k - 1];
                    } else {
                        lookup[i][j][k] = Math.max(lookup[i - 1][j][k], Math.max(lookup[i][j - 1][k], lookup[i][j][k - 1]));
                    }
                }
            }
        }
        return lookup[a][b][c];
    }

    public static void main(String[] args) {
        String A = "geeks";
        String B = "geeksfor";
        String C = "geeksforgeeks";
        System.out.println(lcsOfThreeStrings(A, B, C));

        A = "abcd";
        B = "efgh";
        C = "ijkl";
        System.out.println(lcsOfThreeStrings(A, B, C));
    }
}
