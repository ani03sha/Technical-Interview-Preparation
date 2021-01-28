package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array arr of size N and an integer K.
 * Find if there's a triplet in the array which sums up to the given integer K.
 * <p>
 * Constraints:
 * 1 ≤ N ≤ 10^3
 * 1 ≤ A[i] ≤ 10
 */
public class TripletWithGivenSum {

    private static boolean doesTripletExist(int[] nums, int K) {
        // Base condition
        if (nums == null || nums.length < 3) {
            return false;
        }
        // Sort the array
        Arrays.sort(nums);
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            // Left and right pointers
            int j = i + 1;
            int k = nums.length - 1;
            // Loop until two pointers meet
            while (j < k) {
                // Sum of the triplet
                int sum = nums[i] + nums[j] + nums[k];
                // Check for the sum
                if (sum == K) {
                    return true;
                }
                // If the sum is less than K then we are too left
                // and need to move right
                else if (sum < K) {
                    j++;
                }
                // If the sum is less than K then we are too right
                // and need to move left
                else {
                    k--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 45, 6, 10, 8};
        int k = 13;
        System.out.println(doesTripletExist(nums, k));

        nums = new int[]{1, 2, 4, 3, 6};
        k = 10;
        System.out.println(doesTripletExist(nums, k));
    }
}
