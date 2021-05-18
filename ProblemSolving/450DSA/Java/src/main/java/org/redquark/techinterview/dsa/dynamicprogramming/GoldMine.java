package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which
 * is the amount of gold in tons. Initially the miner is at first column but can be at any row.
 * <p>
 * He can move only (right->,right up /,right down\) that is from a given cell, the miner can
 * move to the cell diagonally up towards the right or right or diagonally down towards the right.
 * <p>
 * Find out maximum amount of gold he can collect.
 */
public class GoldMine {

    private static int calculateMaxGold(int[][] mine) {
        // Special case
        if (mine == null || mine.length == 0) {
            return 0;
        }
        // Rows and columns of the mine
        int m = mine.length;
        int n = mine[0].length;
        // Lookup table to store the maximum gold until a cell
        int[][] lookup = new int[m][n];
        // Start populating the table from the right or last column
        // Populate for remaining cells
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                // If we go to the right
                int right = j == n - 1 ? 0 : lookup[i][j + 1];
                // Going right up
                int rightUp = (i == 0 || j == n - 1) ? 0 : lookup[i - 1][j + 1];
                // Going right down
                int rightDown = (i == m - 1 || j == n - 1) ? 0 : lookup[i + 1][j + 1];
                // Select the max of above three and add it to the
                // gold in the current cell
                lookup[i][j] = mine[i][j] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }
        // Now the maximum amount of gold collected will be the maximum
        // value in the first column
        int maxGoldCollected = 0;
        for (int i = 0; i < m; i++) {
            maxGoldCollected = Math.max(maxGoldCollected, lookup[i][0]);
        }
        return maxGoldCollected;
    }

    public static void main(String[] args) {
        int[][] mine = new int[][]{
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };
        System.out.println(calculateMaxGold(mine));
    }
}
