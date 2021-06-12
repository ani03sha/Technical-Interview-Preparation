package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 */
public class LargestSumContiguousSubarray {

    private static int maxSubarraySum(int[] a) {
        // Length of the array
        int n = a.length;
        // Global maxima
        int globalMax = a[0];
        int localMax = a[0];
        // Loop through the elements of the list
        for (int i = 1; i < n; i++) {
            localMax = Math.max(a[i], a[i] + localMax);
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, -2, 5};
        System.out.println(maxSubarraySum(a));

        a = new int[]{-1, -2, -3, -4};
        System.out.println(maxSubarraySum(a));

    }
}
