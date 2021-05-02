package org.redquark.techinterview.mustdolc75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * LeetCode # 1 - https://leetcode.com/problems/two-sum/ (EASY)
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10^3
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Array of size 2 to store the answer
        int[] pair = new int[2];
        // Map to store the number and its corresponding index
        Map<Integer, Integer> pairMap = new HashMap<>();
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the difference already exists
            if (pairMap.containsKey(nums[i])) {
                pair[0] = pairMap.get(nums[i]);
                pair[1] = i;
            } else {
                pairMap.put(target - nums[i], i);
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        nums = new int[]{3, 3};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
