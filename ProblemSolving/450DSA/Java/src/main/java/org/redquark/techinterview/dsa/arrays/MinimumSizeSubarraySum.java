package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal
 * length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is
 * greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class MinimumSizeSubarraySum {

    private static int minSubArrayLen(int target, int[] nums) {
        // Length of the array
        int n = nums.length;
        // Start and end pointers
        int start = 0;
        int end = 0;
        // Minimum length of the subarray
        int minimumLength = Integer.MAX_VALUE;
        // Sum of the subarray
        int sum = 0;
        // Loop until the end pointer reaches to the end
        // of the array
        while (end < n) {
            // Loop until we get sum greater than or
            // equal to the target
            while (sum < target && end < n) {
                sum += nums[end];
                end++;
            }
            // As soon as we get sum greater than target,
            // we will start removing elements from the start
            while (sum >= target && start < n) {
                minimumLength = Math.min(minimumLength, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return minimumLength == Integer.MAX_VALUE ? 0 : minimumLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));

        nums = new int[]{1, 4, 4};
        target = 4;
        System.out.println(minSubArrayLen(target, nums));

        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }
}
