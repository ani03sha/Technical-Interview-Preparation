package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given N integers and K, find the minimum number of elements that should be removed,
 * such that Amax-Amin<=K. After the removal of elements, Amax and Amin is considered
 * among the remaining elements.
 */
public class MinimumRemovalsFromArray {

    private static int minimumElementsRemoved(int[] nums, int k) {
        // Special cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Length of the array
        int n = nums.length;
        // Lookup table
        int[] lookup = new int[n];
        // Fill with default values
        Arrays.fill(lookup, -1);
        // Base initialization
        lookup[0] = 0;
        // In worst case, all the elements need to be removed
        // except one element
        int removedElements = n - 1;
        // Populate the lookup table
        for (int i = 1; i < n; i++) {
            lookup[i] = i;
            int j = lookup[i - 1];
            while (j != i && nums[i] - nums[j] > k) {
                j++;
            }
            lookup[i] = Math.min(lookup[i], j);
            removedElements = Math.min(removedElements, n - (i - j + 1));
        }
        return removedElements;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 9, 10, 11, 12, 17, 20};
        int k = 4;
        System.out.println(minimumElementsRemoved(nums, k));
    }
}
