package org.redquark.techinterview.dsa.matrix;

/**
 * @author Anirudh Sharma
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 */
public class SearchA2DMatrix {

    private static boolean searchMatrix(int[][] matrix, int target) {
        // Special case
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // Rows and columns of the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Index for rows of the matrix
        int i = 0;
        // Loop row wise
        while (i < rows) {
            if (matrix[i][0] <= target && matrix[i][columns - 1] >= target) {
                // Perform binary search in the current row
                return binarySearch(matrix, i, columns, target);
            }
            i++;
        }
        return false;
    }

    private static boolean binarySearch(int[][] matrix, int row, int column, int target) {
        // Start and end pointers
        int start = 0;
        int end = column - 1;
        // Loop until two pointers meet
        while (start <= end) {
            // Middle index
            int middle = start + (end - start) / 2;
            if (matrix[row][middle] == target) {
                return true;
            } else if (matrix[row][middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));

        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        target = 13;
        System.out.println(searchMatrix(matrix, target));
    }
}
