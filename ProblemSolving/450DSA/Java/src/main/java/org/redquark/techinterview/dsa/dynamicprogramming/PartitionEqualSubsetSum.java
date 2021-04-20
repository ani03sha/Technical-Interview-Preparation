package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a non-empty array nums containing only positive integers, find if the array can be
 * partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {

    private static boolean canPartition(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // Calculate the sum of elements of the array
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // Check if the sum is odd
        if (sum % 2 == 1) {
            return false;
        }
        // Lookup table
        Boolean[][] lookup = new Boolean[nums.length + 1][sum + 1];
        // If the sum is even, then we will fina a subarray
        // whose sum is equal to sum / 2
        return isSubsetSum(nums, nums.length - 1, sum / 2, lookup);
    }

    private static boolean isSubsetSum(int[] nums, int n, int sum, Boolean[][] lookup) {
        // If subarray is found
        if (sum == 0) {
            return true;
        }
        // Base case
        if (sum < 0 || n < 0) {
            return false;
        }
        // Check in cache
        if (lookup[n][sum] != null) {
            return lookup[n][sum];
        }
        return lookup[n][sum] = isSubsetSum(nums, n - 1, sum - nums[n], lookup)
                || isSubsetSum(nums, n - 1, sum, lookup);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));

        nums = new int[]{1, 2, 3, 5};
        System.out.println(canPartition(nums));

        nums = new int[]{3, 1, 1, 2, 2, 1};
        System.out.println(canPartition(nums));

        nums = new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97};
        System.out.println(canPartition(nums));
    }
}
