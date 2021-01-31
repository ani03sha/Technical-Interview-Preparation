package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar
 * is 1, compute how much water it can trap after raining.
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 10^4
 * 0 <= height[i] <= 10^5
 */
public class TrappingRainWater {

    /**
     * @param height - array containing heights of bars
     * @return amount of water that can be trapped
     */
    private static int trap(int[] height) {
        // Special cases
        if (height == null || height.length < 2) {
            return 0;
        }
        // Total water that can be trapped
        int totalWater = 0;
        // Variables to store left max and right max
        int leftMax = 0;
        int rightMax = 0;
        // Left and right pointers
        int left = 0;
        int right = height.length - 1;
        // Loop until two pointers meet
        while (left <= right) {
            // If left wall is smaller than the right wall
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            }
            // If right wall is smaller than the left wall
            else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
