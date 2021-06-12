package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array containing n integers. The problem is to find the sum of the elements of the
 * contiguous subarray having the smallest(minimum) sum.
 */
public class SmallestSumContiguousSubarray {

    private static int smallestSumSubarray(int[] a) {
        // Global and local minimum
        int globalMin = Integer.MAX_VALUE;
        int localMin = Integer.MAX_VALUE;
        // Traverse through the array
        for (int element : a) {
            // If local min is positive, it cannot
            // contribute to the minimum sum
            if (localMin > 0) {
                localMin = element;
            } else {
                localMin += element;
            }
            // Update the minimum
            globalMin = Math.min(localMin, globalMin);
        }
        return globalMin;
    }

    public static void main(String[] args) {
        int[] a = {3, -4, 2, -3, -1, 7, -5};
        System.out.println(smallestSumSubarray(a));
    }
}
