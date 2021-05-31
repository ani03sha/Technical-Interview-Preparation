package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sequence of positive numbers, find the maximum sum that can be formed which has
 * no three consecutive elements present.
 */
public class MaximumSubsequenceSumWithoutThreeConsecutive {

    private static int maxSubsequenceSum(int[] nums) {
        // Special case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Length of the array
        int n = nums.length;
        // Lookup table to store sum in the subarray [0...i]
        // where no three elements are consecutive
        int[] lookup = new int[n];
        // Base initialization
        lookup[0] = nums[0];
        if (n >= 2) {
            lookup[1] = nums[0] + nums[1];
        }
        if (n > 2) {
            lookup[2] = Math.max(lookup[1], Math.max(nums[0] + nums[2], nums[1] + nums[2]));
        }
        // Populate the remaining table
        for (int i = 3; i < n; i++) {
            lookup[i] = Math.max(Math.max(lookup[i - 1], lookup[i - 2] + nums[i]), nums[i] + nums[i - 1] + lookup[i - 3]);
        }
        return lookup[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(maxSubsequenceSum(nums));

        nums = new int[]{3000, 2000, 1000, 3, 10};
        System.out.println(maxSubsequenceSum(nums));

        nums = new int[]{100, 1000, 100, 1000, 1};
        System.out.println(maxSubsequenceSum(nums));

        nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(maxSubsequenceSum(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(maxSubsequenceSum(nums));
    }
}
