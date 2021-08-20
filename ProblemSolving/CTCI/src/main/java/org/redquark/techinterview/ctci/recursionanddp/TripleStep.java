package org.redquark.techinterview.ctci.recursionanddp;

/**
 * @author Anirudh Sharma
 * <p>
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class TripleStep {

    private static int countWays(int n) {
        // Special case
        if (n <= 0) {
            return 0;
        }
        // Lookup table to store the total number of steps
        // for each index
        int[] lookup = new int[n + 1];
        // Base initialization
        lookup[0] = 0;
        lookup[1] = 1;
        lookup[2] = 2;
        lookup[3] = 4;
        for (int i = 4; i <= n; i++) {
            lookup[i] = lookup[i - 1] + lookup[i - 2] + lookup[i - 3];
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(6));
        System.out.println(countWays(7));
    }
}
