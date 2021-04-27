package org.redquark.techinterview.ctci.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
 */
public class Conversion {

    private static int getNumberOfBits(int a, int b) {
        // Count of bits to be flipped
        int count = 0;
        // Loop over only the bits which are different
        int c = a ^ b;
        while (c != 0) {
            count++;
            // Flip LSB
            c &= (c - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfBits(29, 15));
        System.out.println(getNumberOfBits(31, 0));
    }
}
