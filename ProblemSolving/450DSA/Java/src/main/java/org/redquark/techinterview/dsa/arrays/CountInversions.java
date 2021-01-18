package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of integers. Find the Inversion Count in the array.
 * <p>
 * Inversion Count: For an array, inversion count indicates how far (or close) the array
 * is from being sorted. If array is already sorted then the inversion count is 0.
 * <p>
 * If an array is sorted in the reverse order then the inversion count is the maximum.
 * <p>
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 */
public class CountInversions {

    /**
     * @param a - given array
     * @return number of inversion count
     */
    private static long inversionCount(long[] a) {
        long[] auxiliary = new long[a.length];
        return mergeSortAndCount(a, auxiliary, 0, a.length - 1);
    }

    private static long mergeSortAndCount(long[] a, long[] auxiliary, int low, int high) {
        // Count of inversions
        long count = 0;
        // Middle of the array
        int middle;
        // For valid indices
        if (low < high) {
            // Middle index
            middle = low + (high - low) / 2;
            // Left sub array count
            count += mergeSortAndCount(a, auxiliary, low, middle);
            // Right sub array count
            count += mergeSortAndCount(a, auxiliary, middle + 1, high);
            // Merge count
            count += merge(a, auxiliary, low, middle + 1, high);
        }
        return count;
    }

    private static long merge(long[] a, long[] auxiliary, int low, int middle, int high) {
        // Index for left subarray
        int i = low;
        // Index for right subarray
        int j = middle;
        // Index for the auxiliary array
        int k = low;
        // Inversion count
        long inversionCount = 0;
        // Loop until there are elements in the left
        // and right subarrays
        while (i <= middle - 1 && j <= high) {
            if (a[i] <= a[j]) {
                auxiliary[k++] = a[i++];
            } else {
                auxiliary[k++] = a[j++];
                inversionCount += (middle - i);
            }
        }
        // Remaining elements of left subarray are copied
        while (i <= middle - 1) {
            auxiliary[k++] = a[i++];
        }
        // Remaining elements of right subarray are copied
        while (j <= high) {
            auxiliary[k++] = a[j++];
        }
        // Copy the auxiliary array into the main array
        if (high + 1 - low >= 0) {
            System.arraycopy(auxiliary, low, a, low, high + 1 - low);
        }
        return inversionCount;
    }

    public static void main(String[] args) {
        System.out.println(inversionCount(new long[]{2, 4, 1, 3, 5}));
        System.out.println(inversionCount(new long[]{2, 3, 4, 5, 6}));
        System.out.println(inversionCount(new long[]{10, 10, 10}));
        System.out.println(inversionCount(new long[]{4, 3, 2, 1}));
    }
}
