package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing
 * only 1's and return its area.
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 */
public class MaximalSquare {

    private static int maximalSquare(char[][] matrix) {
        // Special case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // Rows and columns of the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        // Lookup table to store the size of the sub-matrix
        // of which current cell is the bottom right corner
        int[][] lookup = new int[m + 1][n + 1];
        // Variable to keep track of biggest square matrix seen so far
        int maxSize = 0;
        // Loop through the matrix and populate the lookup table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current cell has 1, then we can consider
                // it as a valid case and try to make it as the part
                // of the valid sub matrix
                if (matrix[i - 1][j - 1] == '1') {
                    lookup[i][j] = Math.min(lookup[i - 1][j], Math.min(lookup[i - 1][j - 1], lookup[i][j - 1])) + 1;
                    maxSize = Math.max(maxSize, lookup[i][j]);
                }
            }
        }
        return maxSize * maxSize;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix));

        matrix = new char[][]{
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println(maximalSquare(matrix));

        matrix = new char[][]{
                {'0'}
        };
        System.out.println(maximalSquare(matrix));
    }
}
