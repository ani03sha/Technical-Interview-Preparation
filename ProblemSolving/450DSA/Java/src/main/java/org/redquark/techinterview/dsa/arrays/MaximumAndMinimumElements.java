package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Write a function to return minimum and maximum in an array.
 * Your program should make the minimum number of comparisons.
 */
public class MaximumAndMinimumElements {

    /**
     * This method searches for the minimum and maximum elements
     * in the array using linear search
     * <p>
     * Total comparisons: 2(n - 1)
     *
     * @param a - input array
     * @return minimum and maximum elements in the array
     */
    private static int[] findMaxAndMinNormally(int[] a) {
        // Array to store the result
        int[] maxAndMinPair = new int[2];
        // 0th element will store the minimum value
        // 1st element will store the maximum value
        maxAndMinPair[0] = a[0];
        maxAndMinPair[1] = a[0];
        // Loop through the array
        for (int i = 1; i < a.length; i++) {
            maxAndMinPair[0] = Math.min(maxAndMinPair[0], a[i]);
            maxAndMinPair[1] = Math.max(maxAndMinPair[1], a[i]);
        }
        return maxAndMinPair;
    }

    /**
     * This method divides the arrays in two halves and then recursively
     * finds the minimum and maximum values of those halves.
     * <p>
     * Later we find the combined minimum and maximum elements of the
     * halves.
     * <p>
     * Total comparisons ~ 1.5n - 2
     *
     * @param a - input array
     * @return minimum and maximum elements of the array
     */
    private static int[] findMinAndMaxOptimally(int[] a) {
        return findMaxAndMinOptimally(a, 0, a.length - 1);
    }

    private static int[] findMaxAndMinOptimally(int[] a, int low, int high) {
        // Array to store the result
        int[] minAndMaxPair = new int[2];
        // If there is only one element
        if (low == high) {
            minAndMaxPair[0] = minAndMaxPair[1] = a[low];
            return minAndMaxPair;
        }
        // If there are two elements
        if (high == low + 1) {
            minAndMaxPair[0] = Math.min(a[low], a[high]);
            minAndMaxPair[1] = Math.max(a[low], a[high]);
            return minAndMaxPair;
        }
        // If there are more than two elements
        // Mid index
        int mid = low + (high - low) / 2;
        // Recursively get the minimum and maximum elements of
        // two array halves
        int[] minAndMaxLeft = findMaxAndMinOptimally(a, low, mid);
        int[] minAndMaxRight = findMaxAndMinOptimally(a, mid + 1, high);
        // Find the minimum and maximum from minimum and maximum
        // of both the halves
        minAndMaxPair[0] = Math.min(minAndMaxLeft[0], minAndMaxRight[0]);
        minAndMaxPair[1] = Math.max(minAndMaxLeft[1], minAndMaxRight[1]);
        return minAndMaxPair;
    }

    public static void main(String[] args) {
        int[] maxAndMinPair = findMaxAndMinNormally(new int[]{1000, 11, 445, 1, 330, 3000});
        System.out.println("Min: " + maxAndMinPair[0] + ", Max: " + maxAndMinPair[1]);

        maxAndMinPair = findMaxAndMinNormally(new int[]{9, -2, 12, -21, 342, 67, -63, -32456, 43563, 212, 43546});
        System.out.println("Min: " + maxAndMinPair[0] + ", Max: " + maxAndMinPair[1]);

        maxAndMinPair = findMinAndMaxOptimally(new int[]{1000, 11, 445, 1, 330, 3000});
        System.out.println("Min: " + maxAndMinPair[0] + ", Max: " + maxAndMinPair[1]);

        maxAndMinPair = findMinAndMaxOptimally(new int[]{9, -2, 12, -21, 342, 67, -63, -32456, 43563, 212, 43546});
        System.out.println("Min: " + maxAndMinPair[0] + ", Max: " + maxAndMinPair[1]);
    }
}
