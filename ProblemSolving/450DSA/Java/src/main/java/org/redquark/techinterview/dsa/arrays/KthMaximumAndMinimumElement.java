package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * 
 *         Given an array arr[] and a number K where K is smaller than size of
 *         array, the task is to find the Kth smallest element in the given
 *         array. It is given that all array elements are distinct.
 */
public class KthMaximumAndMinimumElement {

    private static int findKthSmallest(int[] nums, int k) {
        return findKthSmallest(nums, k, 0, nums.length - 1);
    }

    private static int findKthSmallest(int[] nums, int k, int left, int right) {
        // Base case i.e. there is single element
        if (left == right) {
            return nums[left];
        }
        // Find the pivot index
        int pivotIndex = partitionSmallest(nums, left, right);
        // Number of elements in the left of the array
        int countLeft = pivotIndex - left + 1;
        // Check for various cases
        // If the number of elements in left is equal to k
        // then pivot is the required element
        if (countLeft == k) {
            return nums[pivotIndex];
        }
        // If number of elements in left is greater than k
        // then we need to move pivot to the left
        else if (countLeft > k) {
            return findKthSmallest(nums, k, left, pivotIndex - 1);
        }
        // If the number of elements in left is less than k
        // then we need to move pivot to the right
        else {
            return findKthSmallest(nums, k - pivotIndex + left - 1, pivotIndex + 1, right);
        }
    }

    private static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k - 1, 0, nums.length - 1);
    }

    private static int findKthLargest(int[] nums, int k, int left, int right) {
        // Base case i.e. there is single element
        if (k < left || k > right) {
            return -1;
        }
        // Find the pivot index
        int pivotIndex = partitionLargest(nums, left, right);
        // Check for various cases
        // If the number of elements in left is equal to k
        // then pivot is the required element
        if (pivotIndex == k) {
            return nums[pivotIndex];
        }
        // If number of elements in left is greater than k
        // then we need to move pivot to the left
        else if (pivotIndex > k) {
            return findKthLargest(nums, k, left, pivotIndex - 1);
        }
        // If the number of elements in left is less than k
        // then we need to move pivot to the right
        else {
            return findKthLargest(nums, k, pivotIndex + 1, right);
        }
    }

    private static int partitionSmallest(int[] nums, int left, int right) {
        // Choosing right most element as the pivot
        int pivot = nums[right];
        // Index to determine the position of last element
        // that should occur before pivot
        int i = left - 1;
        // Loop through the array (until right - 1)
        for (int j = left; j < right; j++) {
            // If current element is less than or equal to the pivot
            // then swap
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        // Swap again
        swap(nums, i + 1, right);
        return i + 1;
    }

    private static int partitionLargest(int[] nums, int left, int right) {
        // Choosing right most element as the pivot
        int pivot = nums[right];
        // Index to determine the position of last element
        // that should occur before pivot
        int i = left;
        // Loop through the array (until right - 1)
        for (int j = left; j < right; j++) {
            // If current element is less than or equal to the pivot
            // then swap
            if (nums[j] > pivot) {
                swap(nums, j, i++);
            }
        }
        // Swap again
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findKthSmallest(new int[] { 7, 10, 4, 3, 20, 15 }, 3));
        System.out.println(findKthSmallest(new int[] { 7, 10, 4, 20, 15 }, 4));
        System.out.println(findKthLargest(new int[] { 7, 10, 4, 20, 15 }, 3));
        System.out.println(findKthLargest(new int[] { 7, 10, 4, 3, 20, 15 }, 1));
    }
}