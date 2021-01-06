package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array, cyclically rotate an array by one.
 */
public class CyclicallyRotateAnArrayByOne {

    /**
     * @param a - input array
     * @return rotated array by one
     */
    private static int[] rotateArray(int[] a) {
        // Base condition
        if (a == null || a.length <= 1) {
            return a;
        }
        // Save the last element of the array for future
        int lastElement = a[a.length - 1];
        // Index pointing at the end of the array
        int i = a.length - 2;
        while (i >= 0) {
            // Copy the current element to its right element
            a[i + 1] = a[i];
            i--;
        }
        // Put the last element at first position (0th index)
        a[0] = lastElement;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(rotateArray(new int[]{1})));
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2})));
        System.out.println(Arrays.toString(rotateArray(new int[]{})));
    }
}
