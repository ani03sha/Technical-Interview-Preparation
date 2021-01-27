package org.redquark.techinterview.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive
 * elements sequence.
 * <p>
 * 0 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * Follow up: Could you implement the O(n) solution?
 */
public class LongestConsecutiveSequence {

    /**
     * @param nums - unsorted array of numbers
     * @return length of the longest consecutive sequence
     */
    private static int longestConsecutive(int[] nums) {
        // Special cases
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // Variable to store the longest consecutive sequence
        int count = 0;
        // Set to store the elements of the array
        Set<Integer> uniqueElements = new HashSet<>();
        // Add all elements in the array to the set
        for (int num : nums) {
            uniqueElements.add(num);
        }
        // Loop again to find the sequences
        for (int num : nums) {
            // Check if the previous number i.e., one smaller
            // is present in the set. If yes, then the current
            // element is a part of a sequence else it is the first
            // element in the sequence
            if (!uniqueElements.contains(num - 1)) {
                // Get the current element
                int n = num;
                // Check if next elements are in the set
                while (uniqueElements.contains(n)) {
                    n++;
                }
                // Update the maximum length
                count = Math.max(count, n - num);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));

        nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));

        nums = new int[]{2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConsecutive(nums));

        nums = new int[]{1, 9, 3, 10, 4, 20, 2};
        System.out.println(longestConsecutive(nums));
    }
}
