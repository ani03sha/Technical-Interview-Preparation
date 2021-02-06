package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of n positive integers and a number k.
 * <p>
 * Find the minimum number of swaps required to bring all the numbers less than or equal to k together.
 * <p>
 * Constraints:
 * 1 ≤ N ≤ 10^5
 * 1 ≤ nums[i], K ≤10^7
 */
public class MinimumSwapsAndKTogether {

    private static int minimumSwaps(int[] nums, int k) {
        // Special cases
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // Count elements which are less than or equal to k
        int lessThanOrEqualToK = 0;
        for (int num : nums) {
            if (num <= k) {
                lessThanOrEqualToK++;
            }
        }
        // Count number of elements which are greater than k
        // int the first window of size lessThanOrEqualToK
        int greaterThanK = 0;
        for (int i = 0; i < lessThanOrEqualToK; i++) {
            if (nums[i] > k) {
                greaterThanK++;
            }
        }
        // Final count of swaps required
        int swaps = greaterThanK;
        // Using two pointer technique
        int left = 0;
        int right = lessThanOrEqualToK;
        // Loop until right pointer reaches to the end
        while (right < nums.length) {
            // Decrement count of previous window
            if (nums[left] > k) {
                --greaterThanK;
            }
            // Increment count of current window
            if (nums[right] > k) {
                ++greaterThanK;
            }
            left++;
            right++;
            swaps = Math.min(swaps, greaterThanK);
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 6, 3};
        int k = 3;
        System.out.println(minimumSwaps(nums, k));

        nums = new int[]{2, 7, 9, 5, 8, 7, 4};
        k = 6;
        System.out.println(minimumSwaps(nums, k));
    }
}
