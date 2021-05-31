package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
 * <p>
 * You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher
 * than f will break, and any egg dropped at or below floor f will not break.
 * <p>
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n).
 * If the egg breaks, you can no longer use it.
 * <p>
 * However, if the egg does not break, you may reuse it in future moves.
 * <p>
 * Return the minimum number of moves that you need to determine with certainty what the value of f is.
 */
public class EggDrop {

    // Lookup table to store the minimum attempts
    // needed to find critical floor with i eggs
    // and j floors
    private static final Integer[][] lookup = new Integer[101][10001];

    private static int eggDrop(int k, int n) {
        // Some base cases
        // 1. If there is only one egg
        // 2. If there is only 0 or 1 floor
        if (k == 1 || n <= 1) {
            return n;
        }
        // 3. If we have already calculated the result
        // using memoization
        if (lookup[k][n] != null) {
            return lookup[k][n];
        }
        // Minimum attempts needed to find critical floor
        int minimum = Integer.MAX_VALUE;
        // Search for the critical floor using binary search
        // Left and right pointers
        int left = 1;
        int right = n;
        // Loop until the two pointers meet
        while (left <= right) {
            // Middle point
            int middle = left + (right - left) / 2;
            // If egg breaks, search below
            int below = eggDrop(k - 1, middle - 1);
            // If egg survives, search above
            int above = eggDrop(k, n - middle);
            // We need worst case from both attempts
            // 1 is added because we have tried once
            // for the middle floor
            int attempts = 1 + Math.max(below, above);
            // If below attempts are less, we need only above
            // attempts and vice-versa
            if (below < above) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            // Minimum attempts for all worst cases
            minimum = Math.min(minimum, attempts);
        }
        return lookup[k][n] = minimum;
    }

    public static void main(String[] args) {
        int k = 1;
        int n = 2;
        System.out.println(eggDrop(k, n));

        k = 2;
        n = 6;
        System.out.println(eggDrop(k, n));

        k = 3;
        n = 14;
        System.out.println(eggDrop(k, n));
    }
}
