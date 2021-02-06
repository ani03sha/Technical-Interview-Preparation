package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of positive integers. We need to make the given array a ‘Palindrome’.
 * The only allowed operation is"merging" (of two adjacent elements).
 * Merging two adjacent elements means replacing them with their sum.
 * <p>
 * The task is to find the minimum number of merge operations required to make the
 * given array a ‘Palindrome’.
 */
public class MinimumMergeOperationsToMakeArrayPalindrome {

    private static int minimumMergeOperations(int[] nums) {
        // Special cases
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // Count of merge operations
        int mergeOperations = 0;
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;
        // Loop until both pointers meet
        while (left <= right) {
            // If both elements are equal then
            // we don't have to do anything
            if (nums[left] == nums[right]) {
                left++;
                right--;
            }
            // If left element is smaller than right
            else if (nums[left] < nums[right]) {
                nums[left + 1] += nums[left];
                left++;
                mergeOperations++;
            }
            // If right element is is smaller than left
            else if (nums[left] > nums[right]) {
                nums[right - 1] += nums[right];
                right--;
                mergeOperations++;
            }
        }
        return mergeOperations;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15, 4, 15};
        System.out.println(minimumMergeOperations(nums));

        nums = new int[]{1, 4, 5, 1};
        System.out.println(minimumMergeOperations(nums));

        nums = new int[]{11, 14, 15, 99};
        System.out.println(minimumMergeOperations(nums));
    }
}
