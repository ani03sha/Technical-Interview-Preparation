package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sorted array key [0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts,
 * where freq[i] is the number of searches for keys[i].
 * <p>
 * Construct a binary search tree of all keys such that the total cost of all the searches is as small
 * as possible.
 * <p>
 * The cost of a BST node is the level of that node multiplied by its frequency. The level of the root is 1.
 */
public class OptimalBinarySearchTree {

    private static int optimalCost(int[] keys, int[] frequencies) {
        // Base case
        if (keys == null || keys.length == 0) {
            return 0;
        }
        // Total number of keys/nodes in BST
        int n = keys.length;
        // Lookup table to store optimal costs
        int[][] lookup = new int[n + 1][n + 1];
        // For single keys
        for (int i = 0; i < n; i++) {
            lookup[i][i] = keys[i];
        }
        // Populate the table
        for (int level = 1; level <= n; level++) {
            for (int i = 0; i <= n - level + 1; i++) {
                int j = level + i - 1;
                lookup[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int x = getSum(frequencies, i, j) + (k > i ? lookup[i][k - 1] : 0) + (k < j ? lookup[k + 1][j] : 0);
                    if (x < lookup[i][j]) {
                        lookup[i][j] = x;
                    }
                }
            }
        }
        return lookup[0][n - 1];
    }

    private static int getSum(int[] frequencies, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            if (k >= frequencies.length) {
                continue;
            }
            sum += frequencies[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] keys = {10, 12, 20};
        int[] frequencies = {34, 8, 50};
        System.out.println(optimalCost(keys, frequencies));
    }
}
