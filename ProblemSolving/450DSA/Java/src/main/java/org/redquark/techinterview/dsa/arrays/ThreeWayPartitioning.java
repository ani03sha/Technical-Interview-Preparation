package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * Given an array of size N and a range [a, b]. The task is to partition the array around the range
 * such that array is divided into three parts.
 * 1) All elements smaller than a come first.
 * 2) All elements in range a to b come next.
 * 3) All elements greater than b appear in the end.
 * <p>
 * The individual elements of three sets can appear in any order. You are required to return the
 * modified array.
 */
public class ThreeWayPartitioning {

    private static int[] threeWayPartition(int[] nums, int a, int b) {
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;
        // Loop for elements in the array
        for (int i = 0; i <= right; ) {
            // If the current element is less
            // than a
            if (nums[i] < a) {
                swap(nums, i, left);
                i++;
                left++;
            }
            // If the current element is greater
            // than b
            else if (nums[i] > b) {
                swap(nums, i, right);
                right--;
            }
            // If the current element is in the
            // range a,b
            else {
                i++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 4};
        int a = 1;
        int b = 2;
        System.out.println(Arrays.toString(threeWayPartition(nums, a, b)));

        nums = new int[]{1, 2, 3};
        a = 1;
        b = 3;
        System.out.println(Arrays.toString(threeWayPartition(nums, a, b)));

        nums = new int[]{87, 78, 16, 94};
        a = 36;
        b = 72;
        System.out.println(Arrays.toString(threeWayPartition(nums, a, b)));
    }
}
