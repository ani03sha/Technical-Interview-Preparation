package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together.
 * The problem is not actually to perform the multiplications, but merely to decide in which order
 * to perform the multiplications.
 */
public class MatrixChainMultiplication {

    private static int chainMultiplication(int[] orders) {
        // Lookup table
        int[][] lookup = new int[orders.length][orders.length];
        // Fill the table with default values
        Arrays.stream(lookup).forEach(a -> Arrays.fill(a, -1));
        return chainMultiplicationHelper(orders, 1, orders.length - 1, lookup);
    }

    private static int chainMultiplicationHelper(int[] orders, int i, int j, int[][] lookup) {
        // Base case
        if (i == j) {
            return 0;
        }
        // Check the cache
        if (lookup[i][j] != -1) {
            return lookup[i][j];
        }
        // Minimum number of operations
        int minimumOperations = Integer.MAX_VALUE;
        // Place parentheses at different positions between
        // first and last matrices and recursively calculate
        // the count of operations
        for (int k = i; k < j; k++) {
            int count = chainMultiplicationHelper(orders, i, k, lookup)
                    + chainMultiplicationHelper(orders, k + 1, j, lookup)
                    + orders[i - 1] * orders[k] * orders[j];
            minimumOperations = Math.min(minimumOperations, count);
        }
        return lookup[i][j] = minimumOperations;
    }

    public static void main(String[] args) {
        int[] orders = new int[]{1, 2, 3, 4, 3};
        System.out.println(chainMultiplication(orders));

        orders = new int[]{10, 30, 5, 60};
        System.out.println(chainMultiplication(orders));
    }
}
