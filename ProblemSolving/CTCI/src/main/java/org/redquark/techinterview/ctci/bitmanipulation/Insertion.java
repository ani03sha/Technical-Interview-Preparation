package org.redquark.techinterview.ctci.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given two 32-bit numbers, Nand M, and two bit positions, i and j.
 * <p>
 * Write a method to insert Minto N such that M starts at bit j and ends at bit i.
 * <p>
 * You can assume that the bits j through i have enough space to fit all of M. That is, if M = 10011, you can
 * assume that there are at least 5 bits between j and i. You would not, for example, have j = 3 and i = 2,
 * because M could not fully fit between bit 3 and bit 2.
 */
public class Insertion {

    private static int insert(int M, int N, int i, int j) {
        // Create a sequence of all ones
        int ones = ~0;
        // Now we need to make all ones before j
        int left = ones << (j + 1);
        // Make all ones after i
        int right = (1 << i) - 1;
        // To create mask, we will have to OR left and right
        int mask = left | right;
        // Clear bits from j to i in N
        int nCleared = N & mask;
        // Shift M by i to make it aligned with N
        int mShifted = M << i;
        // Now we will OR nCleared with mShifted
        return nCleared | mShifted;
    }

    public static void main(String[] args) {
        int M = 19;
        int N = 1024;
        int i = 2;
        int j = 6;
        System.out.println(Integer.toBinaryString(insert(M, N, i, j)));

        M = 8;
        N = 1201;
        i = 3;
        j = 6;
        System.out.println(Integer.toBinaryString(insert(M, N, i, j)));
    }
}
