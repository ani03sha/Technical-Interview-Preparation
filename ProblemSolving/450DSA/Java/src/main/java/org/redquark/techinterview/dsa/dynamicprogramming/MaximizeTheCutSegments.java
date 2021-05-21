package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer N denoting the Length of a line segment.
 * You need to cut the line segment in such a way that the cut
 * length of a line segment each time is either x , y or z.
 * Here x, y, and z are integers.
 * <p>
 * After performing all the cut operations, your total number of cut segments must be maximum.
 */
public class MaximizeTheCutSegments {

    private static int maximizeCuts(int n, int x, int y, int z) {
        // Base case
        if (n <= 0) {
            return 0;
        }
        // Lookup table to store maximum cuts required
        // to cut a rod of certain length
        int[] lookup = new int[n + 1];
        // Store the cuts in an array
        int[] cuts = {x, y, z};
        // Fill this with the default value
        Arrays.fill(lookup, -1);
        // Since we don't need any cut for 0 length
        lookup[0] = 0;
        // Populate the table for remaining lengths
        for (int i = 1; i <= n; i++) {
            for (int cut : cuts) {
                if (cut <= i && lookup[i - cut] != -1) {
                    lookup[i] = Math.max(lookup[i], 1 + lookup[i - cut]);
                }
            }
        }
        return Math.max(lookup[n], 0);
    }

    public static void main(String[] args) {
        int n = 4;
        int x = 2;
        int y = 1;
        int z = 1;
        System.out.println(maximizeCuts(n, x, y, z));

        n = 5;
        x = 5;
        y = 3;
        z = 2;
        System.out.println(maximizeCuts(n, x, y, z));
    }
}
