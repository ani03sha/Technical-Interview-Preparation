package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 * Given a 2D matrix, find the largest rectangular sub-matrix whose sum is 0.
 */
public class LargestRectangularSubmatrixWithZeroSum {

    private static void findMaximumSumZeroMatrix(int[][] matrix) {
        // Special case
        if (matrix == null || matrix.length == 0) {
            return;
        }
        // Order of matrix
        int m = matrix.length;
        int n = matrix[0].length;
        // Array to store the row prefix sum
        int[][] prefixSum = new int[m][n];
        // Base initialization
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, prefixSum[i], 0, n);
        }
        // Calculate the prefix sum of each row
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        // Variables for storing the starting and end
        // points of the largest zero sum sub matrix
        int startRow = 0;
        int endRow = 0;
        int startColumn = 0;
        int endColumn = 0;
        // Maximum size of the matrix
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Stores sum between two columns for each row
                int[] temp = new int[m];
                for (int k = 0; k < m; k++) {
                    temp[k] = prefixSum[k][j] - (i > 0 ? prefixSum[k][i - 1] : 0);
                }
                int currentSum = 0;
                // Map to store the row sum
                Map<Integer, Integer> rowSumMap = new HashMap<>();
                rowSumMap.put(0, -1);
                for (int k = 0; k < m; k++) {
                    currentSum += temp[k];
                    if (rowSumMap.containsKey(currentSum)) {
                        int subMatrixSize = (j - i + 1) * (k - rowSumMap.get(currentSum));
                        if (subMatrixSize > maxSize) {
                            maxSize = subMatrixSize;
                            startColumn = i;
                            endColumn = j;
                            startRow = rowSumMap.get(currentSum) + 1;
                            endRow = k;
                        }
                    } else {
                        rowSumMap.put(currentSum, k);
                    }
                }
            }
        }
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {9, 7, 16, 5},
                {1, -6, -7, 3},
                {1, 8, 7, 9},
                {7, -2, 0, 10}
        };
        findMaximumSumZeroMatrix(matrix);
    }
}
