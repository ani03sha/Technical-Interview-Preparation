package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array (or string), the task is to reverse the array/string.
 */
public class ReverseArrayOrString {

    private static int[] reverseArray(int[] a) {
        // Base conditions
        if (a == null || a.length == 0) {
            return a;
        }
        // Left pointer (moves forward)
        int left = 0;
        // Right pointer (moves backward)
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

    private static String reverseString(String s) {
        // Base conditions
        if (s == null || s.isEmpty()) {
            return s;
        }
        // Convert the string to character array
        char[] chars = s.toCharArray();
        // Left pointer (moves forward)
        int left = 0;
        // Right pointer (moves backward)
        int right = s.length() - 1;
        // Loop until both the pointers meet
        while (left <= right) {
            // Swap the elements
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            // Update the pointers
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        // For arrays
        System.out.println(Arrays.toString(reverseArray(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(reverseArray(new int[]{4, 5, 1, 2})));

        // For strings
        System.out.println(reverseString("Anirudh"));
        System.out.println(reverseString("problem solving"));
    }
}
