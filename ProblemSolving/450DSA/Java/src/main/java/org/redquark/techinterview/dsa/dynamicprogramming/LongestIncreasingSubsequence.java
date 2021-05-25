package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements
 * without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence
 * of the array [0,3,1,6,2,2,7].
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 */
public class LongestIncreasingSubsequence {

    private static int lengthOfLIS(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Length of the array
        int n = nums.length;
        // Lookup table to store the longest increasing
        // subsequence until a certain index.
        // lookup[i] => length of longest increasing sub
        // -sequence ending at index i
        int[] lookup = new int[n];
        // Since every element is an increasing sequence of
        // length 1.
        Arrays.fill(lookup, 1);
        // Loop through the array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lookup[i] < lookup[j] + 1) {
                    lookup[i] = lookup[j] + 1;
                }
            }
        }
        // Find the maximum value in the lookup table
        int longest = 0;
        for (int x : lookup) {
            longest = Math.max(longest, x);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));

        nums = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums));

        nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums));
    }
}
