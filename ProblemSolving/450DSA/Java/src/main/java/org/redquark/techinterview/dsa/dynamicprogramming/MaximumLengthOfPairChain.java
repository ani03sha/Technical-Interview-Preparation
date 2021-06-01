package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 * <p>
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 * <p>
 * Return the length longest chain which can be formed.
 * <p>
 * You do not need to use up all the given intervals. You can select pairs in any order.
 * <p>
 * Constraints:
 * <p>
 * n == pairs.length
 * 1 <= n <= 1000
 * -1000 <= lefti < righti < 1000
 */
public class MaximumLengthOfPairChain {

    private static int findLongestChain(int[][] pairs) {
        // Special case
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        // Sort the array by first value of pairs
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        // Length of the array
        int n = pairs.length;
        // Lookup table to store the maximum chain length
        // until that index
        int[] lookup = new int[n];
        // Since every pair is a valid chain pair of length 1
        Arrays.fill(lookup, 1);
        // Populate the table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Compare the two pairs' first and second values
                if (pairs[i][0] > pairs[j][1]) {
                    lookup[i] = Math.max(lookup[i], lookup[j] + 1);
                }
            }
        }
        // Find the maximum value stored in the lookup table
        int maxLength = Integer.MIN_VALUE;
        for (int l : lookup) {
            maxLength = Math.max(l, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(pairs));

        pairs = new int[][]{{1, 2}, {7, 8}, {4, 5}};
        System.out.println(findLongestChain(pairs));
    }
}
