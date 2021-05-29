package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of
 * all the elements in the subarray is less than k.
 * <p>
 * Note:
 * <p>
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 */
public class SubsequencesProductLessThanK {

    private static int numSubsequencesProductLessThanK(int[] nums, int k) {
        // Special cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Length of the array
        int n = nums.length;
        // Lookup table to store the number of sequences
        // that are required after using first j terms to
        // make product less than i.
        int[][] lookup = new int[k + 1][n + 1];
        // Populate the table for all sums
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                // Number of sequences using j - 1 terms
                lookup[i][j] = lookup[i][j - 1];
                if (nums[j - 1] <= i && nums[j - 1] > 0) {
                    // Number of subsequences using 1 to j - 1
                    // terms and j-th term
                    lookup[i][j] += lookup[i / nums[j - 1]][j - 1] + 1;
                }
            }
        }
        return lookup[k][n];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int k = 10;
        System.out.println(numSubsequencesProductLessThanK(nums, k));

        nums = new int[]{4, 8, 7, 2};
        k = 50;
        System.out.println(numSubsequencesProductLessThanK(nums, k));
    }
}
