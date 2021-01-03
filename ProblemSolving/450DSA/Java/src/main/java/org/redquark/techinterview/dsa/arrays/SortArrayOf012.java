package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

public class SortArrayOf012 {

    private static int[] sort012(int[] nums) {
        // Start and end pointers
        int start = 0;
        int end = nums.length - 1;
        // Index to point current element
        int currentIndex = 0;
        // Loop through until the pointers meet
        while (currentIndex <= end && start < end) {
            // Check if the current element is 0
            if (nums[currentIndex] == 0) {
                // Put whatever at the start at the current index
                nums[currentIndex] = nums[start];
                nums[start] = 0;
                start++;
                currentIndex++;
            }
            // Check if the current element is 2
            else if (nums[currentIndex] == 2) {
                nums[currentIndex] = nums[end];
                nums[end] = 2;
                end--;
            }
            // If the current element is 1
            else {
                currentIndex++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort012(new int[]{2, 0, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(sort012(new int[]{2, 0, 1})));
        System.out.println(Arrays.toString(sort012(new int[]{0})));
        System.out.println(Arrays.toString(sort012(new int[]{1})));
    }
}
