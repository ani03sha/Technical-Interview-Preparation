package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of integers arr[] and a number K.You can pair two numbers of the array
 * if the difference between them is strictly less than K.
 * <p>
 * The task is to find the maximum possible sum of such disjoint pairs.
 * The Sum of P pairs is the sum of all 2P numbers of pairs.
 */
public class PairsWithSpecificDifference {

    private static int maxSumPairWithDifferenceLessThanK(int[] nums, int K) {
        // Special case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Sort the array
        Arrays.sort(nums);
        // Lookup table maximum disjoint sum for first i elements
        int[] lookup = new int[nums.length];
        // Populate the table
        for (int i = 1; i < nums.length; i++) {
            lookup[i] = lookup[i - 1];
            if (nums[i] - nums[i - 1] < K) {
                if (i >= 2) {
                    lookup[i] = Math.max(lookup[i], lookup[i - 2] + nums[i] + nums[i - 1]);
                } else {
                    lookup[i] = Math.max(lookup[i], nums[i] + nums[i - 1]);
                }
            }
        }
        return lookup[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 10, 15, 17, 12, 9};
        int K = 4;
        System.out.println(maxSumPairWithDifferenceLessThanK(nums, K));

        nums = new int[]{5, 15, 10, 300};
        K = 12;
        System.out.println(maxSumPairWithDifferenceLessThanK(nums, K));
    }
}
