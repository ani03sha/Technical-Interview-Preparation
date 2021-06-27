package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sequence of words, and a limit on the number of characters that can be put in one line
 * (line width).
 * Put line breaks in the given sequence such that the lines are printed neatly.
 * Assume that the length of each word is smaller than the line width.
 * <p>
 * The problem is to minimize the following total cost.
 * Cost of a line = (Number of extra spaces in the line)^2
 * Total Cost = Sum of costs for all lines
 */
public class WordWrap {

    private static void wordWrap(int[] words, int lineWidth) {
        // Infinite cost
        int infinity = Integer.MAX_VALUE;
        // Words represent the length of different words
        // Total number of words
        int n = words.length;
        // The below array represents the number of extra spaces
        // left in each line if words from i-th index to j-th index
        // are written i.e. extraSpaces[i][[j] represents the extra
        // spaces left when words[i] to words[j] are written in the
        // single line
        int[][] extraSpaces = new int[n + 1][n + 1];
        // Below array represents the costs of lines which has words
        // from i to j
        int[][] cost = new int[n + 1][n + 1];
        // Below array represents the optimal cost of first word to
        // the i-th word
        int[] optimalCost = new int[n + 1];
        // Below array will be used to store the solution
        int[] print = new int[n + 1];
        // Calculate extra spaces in each combination of words from
        // i to j
        for (int i = 1; i <= n; i++) {
            // Space for the current word
            extraSpaces[i][i] = lineWidth - words[i - 1];
            // For the combination of other words
            for (int j = i + 1; j <= n; j++) {
                extraSpaces[i][j] = extraSpaces[i][j - 1] - words[j - 1] - 1;
            }
        }
        // Now, we will calculate the cost for each line using the
        // cost function (extra spaces) ^ 3.
        // cost[i][j] means the cost of putting words from i to j
        // in a single line
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                // If words take space more than lineWidth
                if (extraSpaces[i][j] < 0) {
                    cost[i][j] = infinity;
                }
                // If we have used all the words i.e. the last line
                else if (j == n && extraSpaces[i][j] >= 0) {
                    cost[i][j] = 0;
                }
                // Calculate the cost
                else {
                    cost[i][j] = extraSpaces[i][j] * extraSpaces[i][j];
                }
            }
        }
        // Now, we will attempt to optimize the cost
        // optimalCost[i] means optimized cost to arrange
        // words  from 1 to i
        optimalCost[0] = 0;
        for (int i = 1; i <= n; i++) {
            optimalCost[i] = infinity;
            for (int j = 1; j <= i; j++) {
                if (optimalCost[j - 1] != infinity && cost[j][i] != infinity
                        && optimalCost[j - 1] + cost[j][i] < optimalCost[i]) {
                    optimalCost[i] = optimalCost[j - 1] + cost[j][i];
                    print[i] = j;
                }
            }
        }
        printSolution(print, n);
    }

    private static int printSolution(int[] p, int n) {
        int k;
        if (p[n] == 1) {
            k = 1;
        } else {
            k = printSolution(p, p[n] - 1) + 1;
        }
        System.out.print(p[n] + " " + n + " ");
        return k;
    }

    public static void main(String[] args) {
        int[] words = new int[]{3, 2, 2, 5};
        int lineWidth = 6;
        wordWrap(words, lineWidth);

        System.out.println();

        words = new int[]{3, 2, 2};
        lineWidth = 4;
        wordWrap(words, lineWidth);
    }
}
