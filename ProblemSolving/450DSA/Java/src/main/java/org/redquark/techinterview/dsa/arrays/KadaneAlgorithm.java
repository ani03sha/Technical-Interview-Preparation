package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 */
public class KadaneAlgorithm {

    /**
     * @param a - input array
     * @return maximum sum
     */
    private static int maxSumSubarray(int[] a) {
        // Base condition
        if (a == null || a.length == 0) {
            return 0;
        }
        // Global maxima
        int globalMax = a[0];
        int localMax = a[0];
        // Loop through the elements of the list
        for (int i = 1; i < a.length; i++) {
            localMax = Math.max(a[i], a[i] + localMax);
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubarray(new int[]{1, 2, 3, -2, 5}));
        System.out.println(maxSumSubarray(new int[]{-1, -2, -3, -4}));
        System.out.println(maxSumSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSumSubarray(new int[]{1}));
        System.out.println(maxSumSubarray(new int[]{0}));
        System.out.println(maxSumSubarray(new int[]{-1}));
    }
}
