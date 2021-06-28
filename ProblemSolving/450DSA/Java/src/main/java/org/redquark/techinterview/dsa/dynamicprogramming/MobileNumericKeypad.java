package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given the mobile numeric keypad. You can only press buttons that are up, left, right, or down to
 * the current button.
 * You are not allowed to press bottom row corner buttons (i.e. * and # ).
 * Given a number N, the task is to find out the number of possible numbers of the given length.
 */
public class MobileNumericKeypad {

    private static long getCount(int N) {
        // Array to store the allowed keys which can
        // be pressed before a certain key
        int[][] allowedKeys = {
                {0, 8},
                {1, 2, 4},
                {1, 2, 3, 5},
                {2, 3, 6},
                {1, 4, 5, 7},
                {2, 4, 5, 6, 8},
                {3, 5, 6, 9},
                {4, 7, 8},
                {5, 7, 8, 9, 0},
                {6, 8, 9}
        };
        // Lookup table to store the total number of
        // combinations where i represents the total
        // number of pressed keys and j represents the
        // actual keys present
        long[][] lookup = new long[N + 1][10];
        // Populate the table
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 1) {
                    lookup[i][j] = 1;
                } else {
                    // Loop for all the allowed previous keys
                    for (int previous : allowedKeys[j]) {
                        lookup[i][j] += lookup[i - 1][previous];
                    }
                }
            }
        }
        // Total sum
        long sum = 0;
        for (long value : lookup[N]) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getCount(1));
        System.out.println(getCount(2));
        System.out.println(getCount(3));
        System.out.println(getCount(4));
        System.out.println(getCount(5));
        System.out.println(getCount(16));
    }
}
