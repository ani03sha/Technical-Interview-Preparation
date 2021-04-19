package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two integers n and r, find nCr.
 * Since the answer may be very large, calculate the answer modulo 10^9+7.
 * <p>
 * Constraints:
 * 1 ≤ n ≤ 1000
 * 1 ≤ r ≤ 800
 */
public class BinomialCoefficient {

    private static long calculateCoefficient(int n, int r) {
        // Lookup table
        long[][] lookup = new long[n + 1][r + 1];
        // Fill the array with default values
        Arrays.stream(lookup).forEach(a -> Arrays.fill(a, -1));
        return calculateCoefficientHelper(n, r, lookup) % 1000000007;
    }

    private static long calculateCoefficientHelper(int n, int r, long[][] lookup) {
        // Base case
        if (n < r) {
            return 0;
        }
        // If r is zero, or n is equal to r
        if (r == 0 || n == r) {
            return 1;
        }
        // Get the memoized value
        if (lookup[n][r] != -1) {
            return lookup[n][r];
        }
        return lookup[n][r] = calculateCoefficientHelper(n - 1, r - 1, lookup)
                + calculateCoefficientHelper(n - 1, r, lookup);
    }

    public static void main(String[] args) {
        int n = 3;
        int r = 2;
        System.out.println(calculateCoefficient(n, r));

        n = 10;
        r = 5;
        System.out.println(calculateCoefficient(n, r));

        n = 778;
        r = 116;
        System.out.println(calculateCoefficient(n, r));
    }
}
