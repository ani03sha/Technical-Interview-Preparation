package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 * <p>
 * Note:
 * <p>
 * You can assume that
 * <p>
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 */
public class CoinChange {

    private static int change(int amount, int[] coins) {
        // DP array to store the amount i.e.
        // dp[i] suggests that number of ways
        // i amount can be made from coins
        int[] dp = new int[amount + 1];
        // For 0 amount, there's only one way,
        // i.e. don't choose anything
        dp[0] = 1;
        // Loop for all the coins
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        System.out.println(change(amount, coins));

        amount = 3;
        coins = new int[]{2};
        System.out.println(change(amount, coins));

        amount = 10;
        coins = new int[]{10};
        System.out.println(change(amount, coins));
    }
}
