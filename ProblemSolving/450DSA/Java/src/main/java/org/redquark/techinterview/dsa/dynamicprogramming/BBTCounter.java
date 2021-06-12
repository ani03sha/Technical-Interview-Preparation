package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a height h, count the maximum number of balanced binary trees possible with height h.
 * Print the result modulo 10^9 + 7.
 */
public class BBTCounter {

    private static long countBT(int h) {
        final int MODULUS = 1000000007;
        // Lookup table to store intermediate results
        long[] lookup = new long[h + 1];
        // Base initialization
        lookup[0] = 1;
        lookup[1] = 1;
        // Populate the remaining table
        for (int i = 2; i <= h; i++) {
            lookup[i] = (lookup[i - 1] * ((2 * lookup[i - 2]) % MODULUS + lookup[i - 1]) % MODULUS) % MODULUS;
        }
        return lookup[h];
    }

    public static void main(String[] args) {
        System.out.println(countBT(2));
        System.out.println(countBT(3));
    }
}
