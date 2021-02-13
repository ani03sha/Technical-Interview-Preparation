package org.redquark.techinterview.dsa.matrix;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an NxN matrix Mat. Sort all elements of the matrix.
 */
public class SortMatrix {

    private static int[][] sort(int[][] matrix) {
        // Special case
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        // Rows and columns of the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Elements of the matrix
        int[] elements = new int[rows * columns];
        // Index of elements array
        int index = 0;
        // Store all the elements of the matrix in the array
        for (int[] row : matrix) {
            for (int i = 0; i < columns; i++) {
                elements[index] = row[i];
                index++;
            }
        }
        // Sort the elements array
        Arrays.sort(elements);
        // Reset the index
        index = 0;
        // Now store the elements in the matrix again
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = elements[index];
                index++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        System.out.println(Arrays.deepToString(sort(matrix)));

        matrix = new int[][]{{1, 5, 3}, {2, 8, 7}, {4, 6, 9}};
        System.out.println(Arrays.deepToString(sort(matrix)));
    }
}
