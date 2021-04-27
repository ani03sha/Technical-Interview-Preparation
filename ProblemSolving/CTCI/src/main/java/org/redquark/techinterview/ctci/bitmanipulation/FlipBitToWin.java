package org.redquark.techinterview.ctci.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * You have an integer and you can flip exactly one bit from a 0 to a 1.
 * Write code to find the length of the longest sequence of 1s you could create.
 */
public class FlipBitToWin {

    private static int findLongestSequenceLength(int n) {
        // Base case - if all bits are 1, then it is
        // already the longest sequence
        if (~n == 0) {
            return 8 * Integer.BYTES;
        }
        // Current and previous lengths of consecutive ones
        int previousLength = 0;
        int currentLength = 0;
        // Maximum length
        int maximumLength = Integer.MIN_VALUE;
        // Loop until n becomes zero
        while (n != 0) {
            // If current bit is 1, then we can
            // increment the current length
            if ((n & 1) == 1) {
                currentLength++;
            }
            // If the current bit is 0, then we will
            // check the next bit
            else if ((n & 1) == 0) {
                // If the next bit is also, zero then we will
                // update the previous length to 0 else to
                // current length
                previousLength = (n & 2) == 0 ? 0 : currentLength;
                // If two consecutive bits are zero then current
                // length will also be zero
                currentLength = 0;
            }
            maximumLength = Math.max(currentLength + previousLength + 1, maximumLength);
            n >>= 1;
        }
        return maximumLength;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSequenceLength(31));
        System.out.println(findLongestSequenceLength(255));
        System.out.println(findLongestSequenceLength(13));
        System.out.println(findLongestSequenceLength(1775));
    }
}
