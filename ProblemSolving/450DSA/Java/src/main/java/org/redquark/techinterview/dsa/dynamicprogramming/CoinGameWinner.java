package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * A and B are playing a game. At the beginning there are n coins. Given two more numbers x and y.
 * In each move a player can pick x or y or 1 coins. A always starts the game.
 * The player who picks the last coin wins the game or the person who is not able to pick any
 * coin loses the game.
 * <p>
 * For a given value of n, find whether A will win the game or not if both are playing optimally.
 */
public class CoinGameWinner {

    private static boolean findWinner(int x, int y, int n) {
        // Lookup table to store the results for different
        // values of n
        boolean[] lookup = new boolean[n + 1];
        // Initial values
        // A cannot pick up any coin
        lookup[0] = false;
        // A can pick up the one and only coin
        lookup[1] = true;
        // Populate the remaining values
        for (int i = 2; i <= n; i++) {
            // If A loses any of i - 1 or i - x or i - y game,
            // then it will definitely win game i
            if (i - 1 >= 0 && !lookup[i - 1]) {
                lookup[i] = true;
            } else if (i - x >= 0 && !lookup[i - x]) {
                lookup[i - x] = true;
            } else if (i - y >= 0 && !lookup[i - y]) {
                lookup[i - y] = true;
            }
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int x = 3;
        int y = 4;
        System.out.println(findWinner(x, y, n));

        n = 2;
        x = 3;
        y = 4;
        System.out.println(findWinner(x, y, n));
    }
}
