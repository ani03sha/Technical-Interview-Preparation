package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the
 * array obtained after merging the above 2 arrays(i.e. array of length 2n).
 * <p>
 * The complexity should be O(log(n)).
 */
public class MedianOfTwoSortedArraysOfEqualSize {

    private static int findMedian(int[] a, int[] b, int n) {
        // Special cases
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return (a[0] + b[0]) / 2;
        }
        if (n == 2) {
            return (Math.max(a[0], b[0]) + Math.min(a[1], b[1])) / 2;
        }
        // Get the medians of the individual arrays
        int ma = n % 2 == 0 ? (a[n / 2] + a[n / 2 - 1]) / 2 : a[n / 2];
        int mb = n % 2 == 0 ? (b[n / 2] + b[n / 2 - 1]) / 2 : b[n / 2];
        // If ma and mb are equal then return either of those
        if (ma == mb) {
            return ma;
        }
        // If ma is less than mb then median must lie in a[...ma] and b[mb...]
        if (ma < mb) {
            return n % 2 == 0
                    ? findMedian(Arrays.copyOfRange(a, n / 2 - 1, n), b, n - n / 2 + 1)
                    : findMedian(Arrays.copyOfRange(a, n / 2, n), b, n - n / 2);
        }
        // If ma is greater than mb then median must lie in a[ma...] and b[...mb]
        return n % 2 == 0
                ? findMedian(Arrays.copyOfRange(b, n / 2 - 1, n), a, n - n / 2 + 1)
                : findMedian(Arrays.copyOfRange(b, n / 2, n), a, n - n / 2);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 6};
        int[] b = new int[]{4, 6, 8, 10};
        System.out.println(findMedian(a, b, 4));

        a = new int[]{1, 2, 15, 26, 38};
        b = new int[]{2, 13, 17, 30, 45};
        System.out.println(findMedian(a, b, 5));
    }
}
