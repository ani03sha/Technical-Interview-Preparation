package org.redquark.techinterview.dsa.matrix;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * <p>
 * Constraints:
 * <p>
 * rows == matrix.length
 * cols == matrix.length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 */
public class MaximalRectangle {

    private static int maximalRectangle(char[][] matrix) {
        // Special cases
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // Rows and columns of the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Array to store every row
        int[] rowArray = new int[columns];
        // Fill the row array with the first row of the matrix
        for (int i = 0; i < columns; i++) {
            rowArray[i] = matrix[0][i] - '0';
        }
        // Calculate the max area for this row
        int maxArea = largestRectangleInHistogram(rowArray);
        // Loop for every other row
        for (int i = 1; i < rows; i++) {
            // Again fill the row array
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '0') {
                    rowArray[j] = 0;
                } else {
                    rowArray[j] += matrix[i][j] - '0';
                }
            }
            maxArea = Math.max(maxArea, largestRectangleInHistogram(rowArray));
        }
        return maxArea;
    }

    private static int largestRectangleInHistogram(int[] heights) {
        // Special cases
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        // Stack to store the index of elements whose value is
        // greater than the top of the stack
        Stack<Integer> indices = new Stack<>();
        // Copy of the heights array
        int[] heightsCopy = Arrays.copyOf(heights, heights.length + 1);
        // Maximum area of the histogram
        int maxArea = 0;
        // Index to iterate array
        int index = 0;
        // Loop through the copy array
        while (index < heightsCopy.length) {
            if (indices.isEmpty() || heightsCopy[index] > heights[indices.peek()]) {
                indices.push(index);
                index++;
            } else {
                // Top of the stack
                int top = indices.pop();
                // Local area
                int localArea = heightsCopy[top] * (indices.isEmpty() ? index : index - indices.peek() - 1);
                maxArea = Math.max(maxArea, localArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));

        matrix = new char[][]{};
        System.out.println(maximalRectangle(matrix));

        matrix = new char[][]{{'0'}};
        System.out.println(maximalRectangle(matrix));

        matrix = new char[][]{{'1'}};
        System.out.println(maximalRectangle(matrix));

        matrix = new char[][]{{'0', '0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
