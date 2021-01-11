package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of integers where each element represents the max number of steps that can
 * be made forward from that element.
 * <p>
 * Find the minimum number of jumps to reach the end of the array (starting from the first element).
 * <p>
 * If an element is 0, then you cannot move through that element.
 */
public class MinimumNumberOfJumps {

    private static int minJumps(int[] a) {
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
        System.out.println(minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
        System.out.println(minJumps(new int[]{1, 4, 3, 2, 6, 7}));
        System.out.println(minJumps(new int[]{2, 3, 1, 1, 2, 4, 2, 0, 1, 1}));
    }
}
