package org.redquark.techinterview.ctci.arraysandstrings;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {

    private static int[][] setZeros(int[][] matrix) {
        // Special case
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        // Rows and columns of the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        // Arrays to keep track of zeros in the matrix
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        // Traverse the matrix to mark the zeros
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        // Loop through both row and column arrays to set zeros
        // in those particular row and column
        for (int i = 0; i < m; i++) {
            if (row[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (column[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 3, 4, 5},
                {0, 1, 2, 3, 4, 5},
                {0, 1, 2, 3, 4, 5},
                {0, 1, 2, 3, 4, 5},
                {0, 1, 2, 3, 4, 5},
                {0, 1, 2, 3, 4, 5}
        };
        System.out.println(Arrays.deepToString(setZeros(matrix)));
    }
}
