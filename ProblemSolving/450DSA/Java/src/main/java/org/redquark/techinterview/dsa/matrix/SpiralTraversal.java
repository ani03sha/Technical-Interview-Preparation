package org.redquark.techinterview.dsa.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralTraversal {

    /**
     * @param matrix - given matrix
     * @return spiral traversal
     */
    private static List<Integer> spiralOrder(int[][] matrix) {
        // List for spiral order
        List<Integer> spiral = new ArrayList<>();
        // Special case
        if (matrix == null || matrix.length == 0) {
            return spiral;
        }
        // Rows and columns of matrix
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Variables to move left, right, top and bottom
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        // Total number of elements in the matrix
        int numberOfElements = rows * columns;
        // Loop until the size of list is equal to number of
        // elements in the matrix
        while (spiral.size() < numberOfElements) {
            // Move from left to right
            for (int i = left; i <= right && spiral.size() < numberOfElements; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;
            // Move from top to bottom
            for (int i = top; i <= bottom && spiral.size() < numberOfElements; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;
            // Move right to left
            for (int i = right; i >= left && spiral.size() < numberOfElements; i--) {
                spiral.add(matrix[bottom][i]);
            }
            bottom--;
            // Move bottom to top
            for (int i = bottom; i >= top && spiral.size() < numberOfElements; i--) {
                spiral.add(matrix[i][left]);
            }
            left++;
        }
        return spiral;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }
}
