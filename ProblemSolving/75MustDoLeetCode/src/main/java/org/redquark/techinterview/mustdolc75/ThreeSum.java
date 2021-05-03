package org.redquark.techinterview.mustdolc75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * LeetCode # 15 - https://leetcode.com/problems/3sum/ (MEDIUM)
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 10^5
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // List to store the triplets
        List<List<Integer>> triplets = new ArrayList<>();
        // Special cases
        if (nums == null || nums.length < 3) {
            return triplets;
        }
        // Sort the array
        Arrays.sort(nums);
        // Length of the array
        int n = nums.length;
        // Loop for each element of the array
        for (int i = 0; i < n; i++) {
            // Skip the duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Left and right pointers
            int j = i + 1;
            int k = n - 1;
            // Loop for pairs defined by j and k
            while (j < k) {
                // Check if this is a valid triplet
                if (nums[i] + nums[j] + nums[k] == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    // Never let j refer to the same element twice
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
                // If we are too left in the array, move right
                else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                // If we too right in the array, move left
                else {
                    k--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

        nums = new int[]{};
        System.out.println(threeSum(nums));

        nums = new int[]{0};
        System.out.println(threeSum(nums));

        nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        System.out.println(threeSum(nums));

    }
}
