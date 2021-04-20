package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Find n-th catalan number
 */
public class NthCatalanNumber {

    private static long findCatalan(int n) {
        // Lookup table
        long[] lookup = new long[n + 1];
        // Fill the table with default values
        Arrays.fill(lookup, -1);
        return findCatalanHelper(n, lookup);
    }

    private static long findCatalanHelper(int n, long[] lookup) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // Check if the value is cached in the lookup table
        if (lookup[n] != -1) {
            return lookup[n];
        }
        // Variable to store result
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += findCatalanHelper(i, lookup) * findCatalanHelper(n - i - 1, lookup);
        }
        // Cache value
        return lookup[n] = result;
    }

    public static void main(String[] args) {
        System.out.println(findCatalan(8));
        System.out.println(findCatalan(14));
        System.out.println(findCatalan(21));
    }
}
