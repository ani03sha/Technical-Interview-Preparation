package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given N friends, each one can remain single or can be paired up with some other friend.
 * Each friend can be paired only once.
 * Find out the total number of ways in which friends can remain single or can be paired up.
 * Note: Since answer can be very large, return your answer mod 10^9+7.
 * <p>
 * Constraints:
 * 1 <= N <= 10^6
 */
public class FriendsPairingProblem {

    private static long countFriendsPairings(int n) {
        // DP array for bottom up approach
        long[] dp = new long[n + 1];
        // If there are zero persons, the number
        // of ways will be zero
        dp[0] = 0;
        // If there is one person, it cannot be paired
        dp[1] = 1;
        // If there are two persons, then there can be only
        // two ways - single and pair
        dp[2] = 2;
        // Loop for remaining persons
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n] % 1_000_000_007;
    }

    public static void main(String[] args) {
        System.out.println(countFriendsPairings(3));
        System.out.println(countFriendsPairings(2));
        System.out.println(countFriendsPairings(4));
        System.out.println(countFriendsPairings(40));
    }
}
