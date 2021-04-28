package org.redquark.techinterview.dsa.bitmanipulation;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs
 * whereas the other two number occur exactly once and are distinct.
 * <p>
 * Find the other two numbers.
 */
public class NonRepeatingNumbers {

    private static int[] nonRepeating(int[] A) {
        // Set the first element as x
        int x = A[0];
        // Loop through the array and find XOR
        for (int i = 1; i < A.length; i++) {
            x ^= A[i];
        }
        // At this point x = a XOR b where
        // a and b are distinct numbers
        // Find the rightmost set bit of x
        int rightmostSetBit = x & -x;
        // Two distinct numbers
        int a = 0;
        int b = 0;
        // Divide the elements into two groups
        for (int p : A) {
            if ((p & rightmostSetBit) != 0) {
                a ^= p;
            } else {
                b ^= p;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 2, 1, 4};
        System.out.println(Arrays.toString(nonRepeating(A)));

        A = new int[]{2, 1, 3, 2};
        System.out.println(Arrays.toString(nonRepeating(A)));
    }
}
