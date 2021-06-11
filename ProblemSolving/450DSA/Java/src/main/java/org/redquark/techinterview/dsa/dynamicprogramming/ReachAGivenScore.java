package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Consider a game where a player can score 3 or 5 or 10 points in a move.
 * Given a total score n, find number of distinct combinations to reach the given score.
 */
public class ReachAGivenScore {

    private static int countCombinations(int n) {
        // Create an array to store the possible score
        int[] scores = {3, 5, 10};
        // Lookup table to store the intermediate results
        int[] lookup = new int[n + 1];
        // Base initialization - 0 can be made with one combination
        // where we don't select anything
        lookup[0] = 1;
        // Populate the remaining table
        for (int score : scores) {
            for (int i = score; i <= n; i++) {
                lookup[i] += lookup[i - score];
            }
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        System.out.println(countCombinations(8));
        System.out.println(countCombinations(20));
        System.out.println(countCombinations(13));
    }
}
