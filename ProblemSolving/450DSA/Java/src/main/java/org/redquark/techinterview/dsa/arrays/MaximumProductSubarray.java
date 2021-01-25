package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 */
public class MaximumProductSubarray {

    private static int maxProduct(int[] nums) {
        // Special cases
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // Overall maximum product
        int globalMaxima = nums[0];
        // Maximum product until a given index
        int localMaxima = nums[0];
        // Minimum product until a given index
        int localMinima = nums[0];
        // Loop for the remaining elements in the array
        for (int i = 1; i < nums.length; i++) {
            // Save localMaxima for localMinima calculation
            int temp = localMaxima;
            localMaxima = Math.max(nums[i], Math.max(localMaxima * nums[i], localMinima * nums[i]));
            localMinima = Math.min(nums[i], Math.min(temp * nums[i], localMinima * nums[i]));
            globalMaxima = Math.max(localMaxima, globalMaxima);
        }
        return globalMaxima;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{6, -3, -10, 0, 2}));
        System.out.println(maxProduct(new int[]{2, 3, 4, 5, -1, 0}));
    }
}
