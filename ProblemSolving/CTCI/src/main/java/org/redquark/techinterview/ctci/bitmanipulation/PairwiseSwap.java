package org.redquark.techinterview.ctci.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Write a program to swap odd and even bits in an integer with as few instructions as possible
 * <p>
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 */
public class PairwiseSwap {

    private static int swapOddEvenBits(int n) {
        return ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        System.out.println(swapOddEvenBits(23));
        System.out.println(swapOddEvenBits(2));
    }
}
