package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array arr of N positive integers, the task is to find the maximum sum increasing
 * subsequence of the given array.
 */
public class MaximumSumIncreasingSubsequence {

    private static int maximumSum(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Length of the array
        int n = nums.length;
        // Lookup table to store the maximum sum until
        // a certain index
        int[] lookup = new int[n];
        // Fill this table with the original array
        System.arraycopy(nums, 0, lookup, 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lookup[i] = Math.max(lookup[i], lookup[j] + nums[i]);
                }
            }
        }
        // Maximum value in the array
        int maximumValue = 0;
        for (int i = 0; i < n; i++) {
            maximumValue = Math.max(maximumValue, lookup[i]);
        }
        return maximumValue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 101, 2, 3, 100};
        System.out.println(maximumSum(nums));

        nums = new int[]{1, 2, 3};
        System.out.println(maximumSum(nums));
    }
}
