package org.redquark.techinterview.ctci.arraysandstrings;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {

    private static String[][] rotate(String[][] matrix) {
        // Order of the matrix
        int N = matrix.length;
        // Special case
        if (matrix.length == 0) {
            return matrix;
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                // Save the value at current index for later
                String temp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][i];
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
                matrix[j][N - 1 - i] = temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        String[][] matrix = new String[][]{
                {"00", "01", "02"},
                {"10", "11", "12"},
                {"20", "21", "22"}
        };
        System.out.println(Arrays.deepToString(rotate(matrix)));

        matrix = new String[][]{
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        System.out.println(Arrays.deepToString(rotate(matrix)));
    }
}
