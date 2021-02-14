package org.redquark.techinterview.dsa.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an m x n matrix, find all common elements present in all rows in O(mn)
 * time and one traversal of matrix.
 */
public class CommonElementsInAllRows {

    private static List<Integer> findCommonElements(int[][] matrix) {
        // Rows and columns of the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;
        // List to store the result
        List<Integer> commonElements = new ArrayList<>();
        // Map to store the element and their count in the
        // current row
        Map<Integer, Integer> countMap = new HashMap<>();
        // Process the first row
        for (int i = 0; i < columns; i++) {
            countMap.put(matrix[0][i], 1);
        }
        // Traverse the rest of the matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // If the element is present in the map
                // but not duplicated in the current row
                if (countMap.get(matrix[i][j]) != null && countMap.get(matrix[i][j]) == i) {
                    // We increment the count of the element
                    countMap.put(matrix[i][j], i + 1);
                    // If this is the last row
                    if (i == rows - 1) {
                        commonElements.add(matrix[i][j]);
                    }
                }
            }
        }
        return commonElements;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 1, 4, 8}, {3, 7, 8, 5, 1}, {8, 7, 7, 3, 1}, {8, 1, 2, 7, 9}};
        System.out.println(findCommonElements(matrix));
    }
}
