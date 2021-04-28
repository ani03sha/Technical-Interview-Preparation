package org.redquark.techinterview.dsa.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
 */
public class CountTotalSetBits {

    private static int totalSetBits(int N) {
        // compensate for zero
        N++;
        // To store the powers of two
        int powerOfTwo = 2;
        // Total set bits
        int setBits = N / 2;
        // Loop until powerOfTwo exceeds N
        while (powerOfTwo <= N) {
            // Total pairs of 0s and 1s
            int pairs = N / powerOfTwo;
            // Get only pairs of 1s and multiply it with powerOfTwo
            setBits += powerOfTwo * (pairs / 2);
            // If pairs were odd
            setBits += (pairs % 2 == 1) ? N % powerOfTwo : 0;
            // Next power of two
            powerOfTwo <<= 1;
        }
        return setBits;
    }

    public static void main(String[] args) {
        System.out.println(totalSetBits(2));
        System.out.println(totalSetBits(14));
    }
}
