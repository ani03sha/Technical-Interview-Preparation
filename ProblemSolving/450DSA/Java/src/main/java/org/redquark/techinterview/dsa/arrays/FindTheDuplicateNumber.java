package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 */
public class FindTheDuplicateNumber {

    private static int findDuplicate(int[] nums) {
        // Slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];
        // Move slow pointer one state ahead
        slow = nums[slow];
        // Move fast pointer two states ahead
        fast = nums[nums[fast]];
        // Loop until the two pointers meet
        while (slow != fast) {
            // Move the slow pointer one step ahead and fast pointer two states ahead
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // Move slow pointer to the start of the array
        slow = nums[0];
        // Loop until the two pointers meet
        while (slow != fast) {
            // Move both pointers one step at a time
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{1, 1}));
        System.out.println(findDuplicate(new int[]{1, 1, 2}));
    }
}
