package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer array arr and an integer difference, return the length of the
 * longest subsequence in arr which is an arithmetic sequence such that the difference
 * between adjacent elements in the subsequence equals difference.
 * <p>
 * A subsequence is a sequence that can be derived from arr by deleting some or no elements
 * without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 */
public class LongestArithmeticSubsequenceOfGivenDifference {

    private static int longestSubsequence(int[] nums, int difference) {
        // Special case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Lookup table to store the difference between the
        // current element and the given difference.
        // This will allow us to mark all the elements that
        // are valid for the subsequence
        Map<Integer, Integer> lookup = new HashMap<>();
        // Variable to store the longest length;
        int longestLength = 0;
        // Loop through the array
        for (int num : nums) {
            lookup.put(num, lookup.getOrDefault(num - difference, 0) + 1);
            longestLength = Math.max(longestLength, lookup.get(num));
        }
        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int difference = 1;
        System.out.println(longestSubsequence(nums, difference));

        nums = new int[]{1, 3, 5, 7};
        difference = 1;
        System.out.println(longestSubsequence(nums, difference));

        nums = new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1};
        difference = -2;
        System.out.println(longestSubsequence(nums, difference));
    }
}
