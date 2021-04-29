package org.redquark.techinterview.dsa.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two numbers x and y, and a range [l, r] where 1 <= l, r <= 32.
 * The task is consider set bits of y in range [l, r] and set these bits in x also.
 */
public class CopySetBitsInARange {

    private static int copy(int x, int y, int l, int r) {
        // Base case
        if (l < 1 || r > 32) {
            return -1;
        }
        // Get the length of the mask
        int maskLength = (1 << (r - l + 1)) - 1;
        // Get the mask by shifting to the requested position
        // and "and" it with y
        int mask = ((maskLength) << (l - 1)) & y;
        x |= mask;
        return x;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 13;
        int l = 2;
        int r = 3;
        System.out.println(copy(x, y, l, r));
    }
}
