package org.redquark.techinterview.dsa.string;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings s and t. Find the minimum number of operations that need to be performed
 * on s to convert it to t.
 * The possible operations are:
 * - Insert
 * - Remove
 * - Replace
 * <p>
 * Constraints:
 * 1 <= Length of both strings <= 100
 * Both the strings are in lowercase.
 */
public class EditDistance {

    public static int editDistance(String s, String t) {
        // Lengths of the strings
        int a = s.length();
        int b = t.length();
        // Lookup table for memoization
        int[][] lookup = new int[a + 1][b + 1];
        // Fill the array with default values
        Arrays.stream(lookup).forEach(array -> Arrays.fill(array, -1));
        return editDistanceHelper(s, t, a, b, lookup);
    }

    private static int editDistanceHelper(String s, String t, int a, int b, int[][] lookup) {
        // If s is empty, then we need to insert
        // all the characters from t.
        if (a == 0) {
            return b;
        }
        // If t is empty, then we need to remove
        // all the characters from s.
        if (b == 0) {
            return a;
        }
        // If the entry is already in the lookup
        if (lookup[a][b] != -1) {
            return lookup[a][b];
        }
        // Check if the last characters of both strings are
        // same, then we will recur for the remaining strings
        if (s.charAt(a - 1) == t.charAt(b - 1)) {
            return lookup[a][b] = editDistanceHelper(s, t, a - 1, b - 1, lookup);
        }
        // If the characters are different, then we will
        // check for all the combinations of both the
        // strings
        return lookup[a][b] = 1 + Math.min(editDistanceHelper(s, t, a, b - 1, lookup), Math.min(editDistanceHelper(s, t, a - 1, b, lookup),
                editDistanceHelper(s, t, a - 1, b - 1, lookup)));
    }

    public static void main(String[] args) {
        String s = "sunday";
        String t = "saturday";
        long start = System.currentTimeMillis();
        int minimumOperations = editDistance(s, t);
        long end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds with result: " + minimumOperations);


        s = "abcdefmnopqr";
        t = "ghijklstuvwx";
        start = System.currentTimeMillis();
        minimumOperations = editDistance(s, t);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds with result: " + minimumOperations);
    }
}
