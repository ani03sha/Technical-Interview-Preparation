package org.redquark.techinterview.dsa.string;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater
 * permutation of list of numbers.
 * <p>
 * If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted
 * in an ascending order. You are given an list of numbers arr[ ] of size N.
 * <p>
 * Constraints:
 * 1 ≤ N ≤ 10000
 */
public class NextPermutation {

    private static int[] nextPermutation(int[] nums) {
        // Length of the array
        int n = nums.length;
        // Index of the first element which is smaller
        // than the element to its right
        int index = -1;
        // Loop from right to left
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        // Base condition
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }
        int j = n - 1;
        // Again swap from right to left to find first element
        // that is greater than the above find element
        for (int i = n - 1; i >= index + 1; i--) {
            if (nums[i] > nums[index]) {
                j = i;
                break;
            }
        }
        // Swap the elements
        swap(nums, index, j);
        // Reverse the array
        reverse(nums, index + 1, n - 1);
        return nums;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 6, 5, 4};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }
}
