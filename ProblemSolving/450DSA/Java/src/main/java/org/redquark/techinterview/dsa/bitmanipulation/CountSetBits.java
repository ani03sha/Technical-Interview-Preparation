package org.redquark.techinterview.dsa.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a positive integer N, print count of set bits in it.
 */
public class CountSetBits {

    private static int countSetBits(int N) {
        // Count of set bits
        int count = 0;
        while (N > 0) {
            N &= (N - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(6));
        System.out.println(countSetBits(31));
        System.out.println(countSetBits(13));
        System.out.println(countSetBits(40));
    }
}
