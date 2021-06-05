package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a NxN matrix of positive integers. There are only three possible moves from a cell Matrix[r][c].
 * <p>
 * Matrix [r+1] [c]
 * Matrix [r+1] [c-1]
 * Matrix [r+1] [c+1]
 * <p>
 * Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
 */
public class MaximumPathSum {

    private static int maximumPath(int[][] matrix) {
        // Special case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // Order of the matrix
        int N = matrix.length;
        // Start from the second last row and move upward
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                // Current value
                int current = matrix[i][j];
                if (j > 0) {
                    current = Math.max(current, matrix[i + 1][j - 1]);
                }
                if (j < N - 1) {
                    current = Math.max(current, matrix[i + 1][j + 1]);
                }
                matrix[i][j] += current;
            }
        }
        // Maximum sum
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, matrix[0][i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {348, 391},
                {618, 193}
        };
        System.out.println(maximumPath(matrix));

        matrix = new int[][]{
                {2, 2},
                {2, 2}
        };
        System.out.println(maximumPath(matrix));
    }
}
