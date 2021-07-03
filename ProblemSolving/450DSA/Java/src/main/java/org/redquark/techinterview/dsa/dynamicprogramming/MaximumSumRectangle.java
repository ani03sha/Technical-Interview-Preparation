package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a 2D matrix, find the maximum sum subarray in it.
 */
public class MaximumSumRectangle {

    private static int maximumSumRectangle(int[][] matrix) {
        // Special case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // Dimensions of the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        // Store the prefix sum of each row
        int[][] prefixSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, prefixSum[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        // Start and end pointers of required rectangle
        int startRow = 0;
        int endRow = 0;
        int startColumn = 0;
        int endColumn = 0;
        // Maximum sum
        int maxSum = Integer.MIN_VALUE;
        // Try for every column
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Stores the between two columns for
                // each row
                int[] temp = new int[m];
                for (int k = 0; k < m; k++) {
                    temp[k] = prefixSum[k][j] - (i > 0 ? prefixSum[k][i - 1] : 0);
                }
                int currentSum = 0;
                int currentMaxSum = 0;
                int currentStartRow = 0;
                int currentEndRow = -1;
                int tempStartRow = 0;
                for (int k = 0; k < m; k++) {
                    currentSum += temp[k];
                    if (currentSum < 0) {
                        currentSum = 0;
                        tempStartRow = k + 1;
                    } else if (currentSum > currentMaxSum) {
                        currentMaxSum = currentSum;
                        currentStartRow = tempStartRow;
                        currentEndRow = k;
                    }
                }
                if (currentEndRow == -1) {
                    currentMaxSum = temp[0];
                    currentStartRow = 0;
                    currentEndRow = 0;
                    for (int k = 1; k < m; k++) {
                        if (temp[k] > currentMaxSum) {
                            currentStartRow = k;
                            currentEndRow = k;
                        }
                    }
                }
                if (currentMaxSum > maxSum) {
                    maxSum = currentMaxSum;
                    startColumn = i;
                    endColumn = j;
                    startRow = currentStartRow;
                    endRow = currentEndRow;
                }
            }
        }
        System.out.println("Maximum sum rectangle:");
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        System.out.println("Max sum: " + maximumSumRectangle(matrix) + "\n");

        matrix = new int[][]{
                {-1, -2},
                {-3, -4}
        };
        System.out.println("Max sum: " + maximumSumRectangle(matrix) + "\n");
    }
}
