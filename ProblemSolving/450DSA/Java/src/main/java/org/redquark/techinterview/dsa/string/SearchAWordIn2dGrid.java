package org.redquark.techinterview.dsa.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a 2D grid of characters and a word, find all occurrences of given word in grid.
 * A word can be matched in all 8 directions at any point.
 * <p>
 * Word is said be found in a direction if all characters match in this direction
 * (not in zig-zag form). The 8 directions are, horizontally left, horizontally right,
 * vertically up, vertically down and 4 diagonal directions.
 * <p>
 * Constraints:
 * 1 <= n <= m <= 100
 * 1 <= |word| <= 10
 */
public class SearchAWordIn2dGrid {

    // Coordinates for searching in all eight directions
    private static final int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static List<List<Integer>> search(char[][] grid, String word) {
        // List to store the results
        List<List<Integer>> result = new ArrayList<>();
        // Loop through every cell of the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (doesWordExist(grid, i, j, word)) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private static boolean doesWordExist(char[][] grid, int row, int column, String word) {
        // Check if the current character in the
        // grid matches with the first character
        // in the word
        if (grid[row][column] != word.charAt(0)) {
            return false;
        }
        // Check word in all eight directions
        for (int i = 0; i < 8; i++) {
            // Starting position for the current direction
            int rowDirection = row + x[i];
            int columnDirection = column + y[i];
            // Number of matched characters
            int matchedCount = 1;
            // Since first character is already checked,
            // we check for remaining characters
            for (int j = 1; j < word.length(); j++) {
                // Check for out of bounds
                if (rowDirection < 0 || rowDirection >= grid.length || columnDirection < 0 || columnDirection >= grid[0].length) {
                    break;
                }
                // If character don't match, break
                if (grid[rowDirection][columnDirection] != word.charAt(j)) {
                    break;
                }
                // Update the matched count
                matchedCount++;
                // Move in a particular direction
                rowDirection += x[i];
                columnDirection += y[i];
            }
            // Check if all the characters matched
            if (matchedCount == word.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'a', 'b', 'c'}, {'d', 'r', 'f'}, {'g', 'h', 'i'}};
        String word = "abc";
        System.out.println(search(grid, word));

        grid = new char[][]{{'a', 'b', 'a', 'b'}, {'a', 'b', 'e', 'b'}, {'e', 'b', 'e', 'b'}};
        word = "abe";
        System.out.println(search(grid, word));
    }
}
