package org.redquark.techinterview.dsa.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given two numbers A and B.
 * The task is to count the number of bits needed to be flipped to convert A to B.
 * <p>
 * Constraints:
 * 1 ≤ A, B ≤ 10^6
 */
public class BitDifference {

    private static int countBits(int A, int B) {
        // Variable to store count
        int count = 0;
        // Variable to store XOR of A and B
        int C = A ^ B;
        // Loop until C becomes 0
        while (C != 0) {
            count++;
            C &= (C - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBits(10, 20));
        System.out.println(countBits(20, 25));
    }
}
