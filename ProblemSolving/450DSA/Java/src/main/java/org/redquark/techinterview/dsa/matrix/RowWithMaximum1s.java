package org.redquark.techinterview.dsa.matrix;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a boolean 2D array of n x m dimensions where each row is sorted.
 * Find the 0-based index of the first row that has the maximum number of 1's.
 * <p>
 * Constraints:
 * 1 ≤ N, M ≤ 10^3
 * 0 ≤ Arr[i][j] ≤ 1
 */
public class RowWithMaximum1s {

    private static int rowWithMaximum1s(int[][] matrix) {
        // Index of rows with maximum 1s
        int rowWithMaximum1sIndex = -1;
        // Rows and columns of the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Current column
        int currentColumn = columns - 1;
        // Loop for every row
        for (int i = 0; i < rows; i++) {
            // Start from top right corner of the matrix
            while (currentColumn >= 0 && matrix[i][currentColumn] == 1) {
                currentColumn--;
                rowWithMaximum1sIndex = i;
            }
        }
        return rowWithMaximum1sIndex;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println(rowWithMaximum1s(matrix));

        matrix = new int[][]{{0, 0}, {1, 1}};
        System.out.println(rowWithMaximum1s(matrix));
    }
}
