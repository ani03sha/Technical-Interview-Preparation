package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of non-negative integers nums, you are initially positioned at the first
 * index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * You can assume that you can always reach the last index.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 */
public class MinimumNumberOfJumps {

    private static int jump(int[] a) {
        // Current position
        int currentPosition = 0;
        // Destination reached from an index
        int destination = 0;
        // Number of jumps required
        int jumps = 0;
        // Loop for the elements of the array
        for (int i = 0; i < a.length - 1; i++) {
            // Destination index will be maximum of the current position
            // and the index that can be reached after jumping
            destination = Math.max(destination, i + a[i]);
            // If we need to take jump
            if (currentPosition == i) {
                currentPosition = destination;
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(a));

        a = new int[]{2, 3, 0, 1, 4};
        System.out.println(jump(a));
    }
}