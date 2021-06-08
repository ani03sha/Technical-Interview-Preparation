package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array cost[] of positive integers of size N and an integer W, cost[i] represents
 * the cost of ‘i’ kg packet of oranges, the task is to find the minimum cost to buy W kgs of oranges.
 * <p>
 * If it is not possible to buy exactly W kg oranges then the output will be -1
 * <p>
 * Note:
 * 1. cost[i] = -1 means that ‘i’ kg packet of orange is unavailable
 * 2. It may be assumed that there is infinite supply of all available packet types.
 */
public class MinimumCostToFillGivenWeightInABag {

    private static int minimumCost(int[] cost, int W) {
        // Special case
        if (cost == null || cost.length == 0) {
            return -1;
        }
        // Length of the cost array
        int N = cost.length;
        // Lookup table to store minimum cost
        int[] lookup = new int[W + 1];
        // Fill the array with default values
        Arrays.fill(lookup, Integer.MAX_VALUE);
        // Base initialization
        lookup[0] = 0;
        // Populate the table
        for (int i = 1; i <= W; i++) {
            for (int j = 0; j < i; j++) {
                if (j < N && cost[j] != -1) {
                    int difference = lookup[i - j - 1];
                    if (difference != Integer.MAX_VALUE) {
                        lookup[i] = Math.min(lookup[i], difference + cost[j]);
                    }
                }
            }
        }
        return lookup[W] == Integer.MAX_VALUE ? -1 : lookup[W];
    }

    public static void main(String[] args) {
        int[] cost = new int[]{20, 10, 4, 50, 100};
        int W = 5;
        System.out.println(minimumCost(cost, W));

        cost = new int[]{-1, -1, 4, 3, -1};
        W = 5;
        System.out.println(minimumCost(cost, W));
    }
}
