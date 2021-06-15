package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a set of N items, each with a weight and a value, and a weight limit W.
 * <p>
 * Find the maximum value of a collection containing any of the N items any number
 * of times so that the total weight is less than or equal to W.
 */
public class UnboundedKnapsack {

    private static int unboundedKnapsack(int[] values, int[] weights, int W) {
        // Special cases
        if (values == null || weights == null || values.length == 0 || weights.length == 0) {
            return 0;
        }
        // Lookup table to store the collection
        int[] lookup = new int[W + 1];
        // Populated lookup table
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < values.length; j++) {
                if (weights[j] <= i) {
                    lookup[i] = Math.max(lookup[i], values[j] + lookup[i - weights[j]]);
                }
            }
        }
        return lookup[W];
    }

    public static void main(String[] args) {
        int[] values = new int[]{1, 1};
        int[] weights = new int[]{2, 1};
        int W = 3;
        System.out.println(unboundedKnapsack(values, weights, W));

        values = new int[]{1, 4, 5, 7};
        weights = new int[]{1, 3, 4, 5};
        W = 8;
        System.out.println(unboundedKnapsack(values, weights, W));
    }
}
