package org.redquark.techinterview.mustdolc75;

/**
 * @author Anirudh Sharma
 * <p>
 * LeetCode # 11 - https://leetcode.com/problems/container-with-most-water/ (MEDIUM)
 * <p>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * <p>
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        // Variable to store maximum area
        int maxArea = Integer.MIN_VALUE;
        // Left and right pointers
        int left = 0;
        int right = height.length - 1;
        // Loop until the two pointers meet
        while (left <= right) {
            // Get the shorter of the two bars
            int shorterBar = Math.min(height[left], height[right]);
            // Calcualte the maxArea using these two bars
            maxArea = Math.max(maxArea, shorterBar * (right - left));
            // Remove shorter of the two bars for further considerations
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));

        height = new int[]{1, 1};
        System.out.println(maxArea(height));

        height = new int[]{4, 3, 2, 1, 4};
        System.out.println(maxArea(height));

        height = new int[]{1, 2, 1};
        System.out.println(maxArea(height));
    }
}
