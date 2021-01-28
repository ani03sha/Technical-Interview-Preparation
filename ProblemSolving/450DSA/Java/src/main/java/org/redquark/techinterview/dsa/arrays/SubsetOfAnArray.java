package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two arrays: arr1[0..m-1] of size m and arr2[0..n-1] of size n.
 * Task is to check whether arr2[] is a subset of arr1[] or not.
 */
public class SubsetOfAnArray {

    private static boolean isSubset(int[] arr1, int[] arr2) {
        // Lengths of the two arrays
        int m = arr1.length;
        int n = arr2.length;
        // Base condition
        if (m < n) {
            return false;
        }
        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // Indices to traverse arr1 and arr2
        int i = 0;
        int j = 0;
        // Loop for both arrays until elements left
        while (i < m && j < n) {
            // If the current element of arr1 is less
            // than the current element of arr2, it means
            // we need to search further in arr1
            if (arr1[i] < arr2[j]) {
                i++;
            }
            // If both current elements are equal,
            // we will move forward in both arrays
            else if (arr1[i] == arr2[j]) {
                i++;
                j++;
            }
            // If the current element in arr1 is greater
            // than the current element in arr2, it means
            // the current element in arr2 is not present
            // in arr1, so we will return false
            else {
                return false;
            }
        }
        // After traversing the whole arrays, i cannot be
        // less than the number of elements in arr2.
        return i >= n;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{11, 1, 13, 21, 3, 7};
        int[] arr2 = new int[]{11, 3, 7, 1};
        System.out.println(isSubset(arr1, arr2));

        arr1 = new int[]{1, 2, 3, 4, 5, 6};
        arr2 = new int[]{1, 2, 4};
        System.out.println(isSubset(arr1, arr2));

        arr1 = new int[]{10, 5, 2, 23, 19};
        arr2 = new int[]{19, 5, 3};
        System.out.println(isSubset(arr1, arr2));
    }
}
