package org.redquark.techinterview.dsa.matrix;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a row wise sorted matrix of size RxC where R and C are always odd,
 * find the median of the matrix.
 * <p>
 * Constraints:
 * 1<= R,C <=150
 * 1<= matrix[i][j] <=1000
 */
public class FindMedianInARowWiseSortedMatrix {

    private static int findMedian(int[][] matrix) {
        // Rows and columns in the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Special cases
        if (rows == 1 && columns == 1) {
            return matrix[rows - 1][columns - 1];
        }
        // Maximum and minimum elements in the matrix
        int minimumElement = Integer.MAX_VALUE;
        int maximumElement = Integer.MIN_VALUE;
        // Loop through all the rows
        for (int[] row : matrix) {
            minimumElement = Math.min(minimumElement, row[0]);
            maximumElement = Math.max(maximumElement, row[columns - 1]);
        }
        // Since now we have a range of minimum and maximum elements
        // in the matrix, we would run binary search on this range to
        // find the number of elements which are less than our median
        // index (rows + columns + 1) / 2.
        // Desired median index
        int desiredIndex = (rows * columns + 1) / 2;
        while (minimumElement < maximumElement) {
            // Middle element
            int middleElement = minimumElement + (maximumElement - minimumElement) / 2;
            // Count of elements less than middleElement
            int count = 0;
            // Loop for each row
            for (int[] row : matrix) {
                // Index of middle element in a row
                int middleElementIndex = Arrays.binarySearch(row, middleElement);
                // If element is not found in the row
                if (middleElementIndex < 0) {
                    middleElementIndex = Math.abs(middleElementIndex) - 1;
                } else {
                    // If element is found in the array
                    while (middleElementIndex < columns && row[middleElementIndex] == middleElement) {
                        middleElementIndex++;
                    }
                }
                count += middleElementIndex;
            }
            if (count < desiredIndex) {
                minimumElement = middleElement + 1;
            } else {
                maximumElement = middleElement;
            }
        }
        return minimumElement;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(findMedian(matrix));
    }
}
