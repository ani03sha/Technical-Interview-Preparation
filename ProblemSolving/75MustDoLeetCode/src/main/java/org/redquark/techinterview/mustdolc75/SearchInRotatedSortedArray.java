package org.redquark.techinterview.mustdolc75;

/**
 * @author Anirudh Sharma
 * <p>
 * LeetCode #33 - https://leetcode.com/problems/search-in-rotated-sorted-array (MEDIUM)
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is guaranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        // Base case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // Start and end pointers
        int left = 0;
        int right = nums.length - 1;
        // First we will find the pivot
        // Loop until the pointers meet
        while (left < right) {
            // Caclulate the middle element
            int middle = left + (right - left) / 2;
            // If the element at middle is greater
            // than the element at right, then the
            // array is rotated at an index greater
            // than middle
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            }
            // If the element is smaller than the
            // element at the right, it means the
            // array is rotated at and index smaller
            // than the middle
            else {
                right = middle;
            }
        }
        // At this point, the left index will be pivot
        int pivot = left;
        // Reset left and right pointers
        left = 0;
        right = nums.length - 1;
        // Now, we will determine in which half of the
        // array, our target is present
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot;
        }
        // Perform binary search in the new left/right boundaries
        while (left <= right) {
            // Middle index
            int middle = left + (right - left) / 2;
            // If the element is found
            if (nums[middle] == target) {
                return middle;
            }
            // If the element is in the left half
            else if (target < nums[middle]) {
                right = middle - 1;
            }
            // If the element is in the right half
            else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));

        target = 3;
        System.out.println(search(nums, target));

        nums = new int[]{1};
        target = 0;
        System.out.println(search(nums, target));
    }
}
