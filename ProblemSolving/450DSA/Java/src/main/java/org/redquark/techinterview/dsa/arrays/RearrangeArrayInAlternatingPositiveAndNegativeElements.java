package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of positive and negative numbers, arrange them in an alternate fashion such that
 * every positive number is followed by negative and vice-versa maintaining the order of appearance.
 * <p>
 * Number of positive and negative numbers need not be equal. If there are more positive numbers
 * they appear at the end of the array. If there are more negative numbers, they too appear in the
 * end of the array.
 * <p>
 * The space complexity should be O(1)
 */
public class RearrangeArrayInAlternatingPositiveAndNegativeElements {

    private static int[] rearrange(int[] a) {
        // Special cases
        if (a == null || a.length <= 1) {
            return a;
        }
        // Loop for all the elements in the array
        for (int i = 0; i < a.length; i++) {
            // Check if the elements is at its correct
            // position or not.
            // Negative element should be at even index
            // and positive element should be at odd index
            if (isAtCorrectPosition(a, i)) {
                // Get the index of next element of opposite sign
                int nextOppositeElementIndex = getNextElementOfOppositeSign(a, i);
                if (nextOppositeElementIndex != -1) {
                    rightRotateSubarray(a, i, nextOppositeElementIndex);
                } else {
                    break;
                }
            }
        }
        return a;
    }

    private static void rightRotateSubarray(int[] a, int left, int right) {
        int lastElementOfSubarray = a[right];
        if (right - left >= 0) {
            System.arraycopy(a, left, a, left + 1, right - left);
        }
        a[left] = lastElementOfSubarray;
    }

    private static int getNextElementOfOppositeSign(int[] a, int index) {
        for (int i = index + 1; i < a.length; i++) {
            if (a[i] * a[index] < 0) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isAtCorrectPosition(int[] a, int index) {
        if (index % 2 == 0) {
            return a[index] > 0;
        } else {
            return a[index] < 0;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        System.out.println(Arrays.toString(rearrange(a)));

        a = new int[]{-1, 3, 2, 4, 5, -6, 7, -9};
        System.out.println(Arrays.toString(rearrange(a)));
    }
}
