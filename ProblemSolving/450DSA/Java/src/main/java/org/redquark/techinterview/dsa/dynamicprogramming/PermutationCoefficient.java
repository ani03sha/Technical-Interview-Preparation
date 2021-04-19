package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two integers n and r, find nPr.
 * Since the answer may be very large, calculate the answer modulo 10^9+7.
 * <p>
 * Constraints:
 * 1 ≤ n ≤ 1000
 * 1 ≤ r ≤ 800
 */
public class PermutationCoefficient {

    private static int calculateCoefficient(int n, int r) {
        // Lookup table
        int[][] lookup = new int[n + 1][r + 1];
        // Fill the table with default values
        Arrays.stream(lookup).forEach(a -> Arrays.fill(a, -1));
        return calculateCoefficientHelper(n, r, lookup);
    }

    private static int calculateCoefficientHelper(int n, int r, int[][] lookup) {
        if (n < r) {
            return 0;
        }
        if (r == 0) {
            return 1;
        }
        if (lookup[n][r] != -1) {
            return lookup[n][r];
        }
        return lookup[n][r] = calculateCoefficient(n - 1, r) + r * calculateCoefficient(n - 1, r - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        int r = 2;
        System.out.println(calculateCoefficient(n, r));

        n = 10;
        r = 3;
        System.out.println(calculateCoefficient(n, r));

        n = 10;
        r = 0;
        System.out.println(calculateCoefficient(n, r));

        n = 10;
        r = 1;
        System.out.println(calculateCoefficient(n, r));
    }
}
