package org.redquark.techinterview.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of positive and negative numbers.
 * Find if there is a subarray (of size at-least one) with 0 sum.
 */
public class SubarrayWithZeroSum {

    private static boolean doesZeroSumExist(int[] A) {
        // Set to store the cumulative sum
        Set<Integer> cumulativeSum = new HashSet<>();
        // Cumulative sum
        int sum = 0;
        // Loop through all the elements in the array
        for (int value : A) {
            sum += value;
            if (value == 0 || sum == 0 || cumulativeSum.contains(sum)) {
                return true;
            }
            cumulativeSum.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(doesZeroSumExist(new int[]{4, 2, -3, 1, 6}));
        System.out.println(doesZeroSumExist(new int[]{4, 2, 0, 1, 6}));
    }
}
