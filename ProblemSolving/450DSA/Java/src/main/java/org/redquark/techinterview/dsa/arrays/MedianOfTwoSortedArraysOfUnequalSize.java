package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two sorted arrays a and b of size m and n respectively,
 * return the median of the two sorted arrays.
 * <p>
 * Follow up: The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArraysOfUnequalSize {

    /**
     * @param a - first sorted array
     * @param b - second sorted array
     * @return median of combined sorted array
     */
    private static double findMedianSortedArrays(int[] a, int[] b) {
        // We will be assuming that a is the smaller array of the two
        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }
        // Lengths of both the arrays
        int m = a.length;
        int n = b.length;
        // Start and end indices for binary search
        int start = 0;
        int end = m;
        // Loop until the pointers meet
        while (start <= end) {
            // Partitions for a and b arrays
            int partitionA = start + (end - start) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;
            // Calculate the ledt and right boundary elements
            int leftMaxA = partitionA == 0 ? Integer.MIN_VALUE : a[partitionA - 1];
            int rightMinA = partitionA == m ? Integer.MAX_VALUE : a[partitionA];
            int leftMaxB = partitionB == 0 ? Integer.MIN_VALUE : b[partitionB - 1];
            int rightMinB = partitionB == n ? Integer.MAX_VALUE : b[partitionB];
            // Check if we have found the elements
            if (leftMaxA <= rightMinB && leftMaxB <= rightMinA) {
                // Check if the length is even
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftMaxA, leftMaxB) + Math.min(rightMinA, rightMinB)) / 2.0;
                } else {
                    return Math.max(leftMaxA, leftMaxB);
                }
            }
            // If we are too far on the right of a
            else if (leftMaxA > rightMinB) {
                end = partitionA - 1;
            }
            // If we are too far on the right of a
            else {
                start = partitionA + 1;
            }
        }
        throw new IllegalArgumentException("Arrays are not sorted!");
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2};
        System.out.println(findMedianSortedArrays(a, b));

        a = new int[]{1, 2};
        b = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(a, b));

        a = new int[]{0, 0};
        b = new int[]{0, 0};
        System.out.println(findMedianSortedArrays(a, b));

        a = new int[]{};
        b = new int[]{1};
        System.out.println(findMedianSortedArrays(a, b));

        a = new int[]{2};
        b = new int[]{};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
