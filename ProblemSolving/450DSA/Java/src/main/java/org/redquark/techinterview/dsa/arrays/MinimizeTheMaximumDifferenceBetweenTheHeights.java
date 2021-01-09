package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify
 * the height of each tower either by increasing or decreasing them by K only once.
 * <p>
 * After modifying, height should be a non-negative integer.
 * <p>
 * Find out what could be the possible minimum difference of the height of shortest and
 * longest towers after you have modified each tower.
 */
public class MinimizeTheMaximumDifferenceBetweenTheHeights {

    private static int getMinDiff(int[] a, int k) {
        // Length of the array
        int n = a.length;
        // Base condition
        if (n <= 1) {
            return 0;
        }
        // Sort the array
        Arrays.sort(a);
        // Maximum difference
        int maximumDifference = a[n - 1] - a[0];
        // Biggest height
        int biggest = a[n - 1] - k;
        // Smallest height
        int smallest = a[0] + k;
        if (smallest > biggest) {
            int temp = smallest;
            smallest = biggest;
            biggest = temp;
        }
        // Loop for the remaining elements of the array
        for (int i = 1; i < n - 1; i++) {
            // Value after adding k to current value
            int add = a[i] + k;
            // Value after subtracting k from current value
            int subtract = a[i] - k;
            if (subtract >= smallest || add <= biggest) {
                continue;
            }
            if (biggest - subtract <= add - smallest) {
                smallest = subtract;
            } else {
                biggest = add;
            }
        }
        return Math.min(maximumDifference, biggest - smallest);
    }

    public static void main(String[] args) {
        System.out.println(getMinDiff(new int[]{1, 15, 10}, 6));
        System.out.println(getMinDiff(new int[]{1, 5, 15, 10}, 3));
        System.out.println(getMinDiff(new int[]{1, 5, 8, 10}, 2));
        System.out.println(getMinDiff(new int[]{3, 9, 12, 16, 20}, 3));
        System.out.println(getMinDiff(new int[]{6, 1, 9, 1, 1, 7, 9, 5, 2, 10}, 4));
    }
}
