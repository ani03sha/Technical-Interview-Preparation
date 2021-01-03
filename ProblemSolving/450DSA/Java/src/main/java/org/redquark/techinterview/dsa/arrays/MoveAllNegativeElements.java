package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * An array contains both positive and negative numbers in random order. Rearrange the array elements so that all
 * negative numbers appear before all positive numbers.
 */
public class MoveAllNegativeElements {

    private static int[] moveNegatives(int[] a) {
        // Left and right pointers
        int left = 0;
        int right = a.length - 1;
        // Loop through the array until two pointers meet
        while (left <= right) {
            // Case 1: both elements are negative
            if (a[left] < 0 && a[right] < 0) {
                left++;
            }
            // Case 2: If both elements are positive
            else if (a[left] > 0 && a[right] > 0) {
                right--;
            }
            // Case 3: If left is positive and right is negative
            else if (a[left] > 0 && a[right] < 0) {
                // Swap
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                // Update the pointers
                left++;
                right--;
            }
            // Case 4: If left is negative and right is positive
            else {
                left++;
                right--;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveNegatives(new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9})));
        System.out.println(Arrays.toString(moveNegatives(new int[]{-12, 11, -13, -5, 6, -7, 5, -3, 11})));
    }
}
