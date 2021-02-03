package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array A of positive integers of size N, where each value represents number of chocolates in a packet.
 * Each packet can have variable number of chocolates.
 * <p>
 * There are M students, the task is to distribute chocolate packets such that :
 * 1. Each student gets one packet.
 * 2. The difference between the number of chocolates given to the students having packet
 * with maximum chocolates and student having packet with minimum chocolates is minimum.
 * <p>
 * Constraints:
 * 1 <= N <= 10^7
 * 1 <= A[i] <= 10^18
 * 1 <= M <= N
 */
public class ChocolateDistribution {

    private static int distribute(int[] A, int M) {
        // Special case
        if (A == null || A.length < M) {
            return 0;
        }
        // Minimum difference between max and min chocolates
        int minimumDifference = Integer.MAX_VALUE;
        // Sort the array
        Arrays.sort(A);
        // Loop through the array in the window of size M
        for (int i = 0; i + M - 1 < A.length; i++) {
            // Difference between current min and max
            int difference = A[i + M - 1] - A[i];
            minimumDifference = Math.min(difference, minimumDifference);
        }
        return minimumDifference;
    }

    public static void main(String[] args) {
        int[] A = new int[]{7, 3, 2, 4, 9, 12, 56};
        int M = 3;
        System.out.println(distribute(A, M));

        A = new int[]{3, 4, 1, 9, 56, 7, 9, 12};
        M = 5;
        System.out.println(distribute(A, M));

        A = new int[]{12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        M = 7;
        System.out.println(distribute(A, M));
    }
}
