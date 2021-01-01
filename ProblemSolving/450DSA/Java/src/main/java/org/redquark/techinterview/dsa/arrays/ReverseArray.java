package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

public class ReverseArray {

    private static int[] reverse(int[] a) {
        // Base conditions
        if (a == null || a.length == 0) {
            return a;
        }
        // Left pointer
        int left = 0;
        // Right pointer
        int right = a.length - 1;
        // Loop until both pointers meet
        while (left <= right) {
            // Swap the left and right elements
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            // Update the value of pointers
            left++;
            right--;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(reverse(new int[]{4, 5, 1, 2})));
    }
}
