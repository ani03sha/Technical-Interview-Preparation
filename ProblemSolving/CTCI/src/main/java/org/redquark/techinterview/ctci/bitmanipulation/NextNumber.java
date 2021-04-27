package org.redquark.techinterview.ctci.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a positive integer, print the next smallest and the next largest number that have the same number
 * of 1 bits in their binary representation.
 */
public class NextNumber {

    private static int getNext(int n) {
        // Counts for zeros and ones
        int zeroCount = 0;
        int oneCount = 0;
        int c = n;
        // Check for trailing zeros
        while ((c & 1) == 0 && c != 0) {
            zeroCount++;
            c >>= 1;
        }
        // Check for ones after non-trailing zero
        while ((c & 1) == 1) {
            oneCount++;
            c >>= 1;
        }
        // Total number of bits after non-trailing zero
        int p = zeroCount + oneCount;
        // Overflow and underflow check
        if (p == 31 || p == 0) {
            return -1;
        }
        // Flip the bit at p-th position
        n |= (1 << p);
        // Now make all the bits after p-th position as zero
        n &= -(1 << p);
        // Insert (oneCount - 1) ones from the right
        n |= (1 << (oneCount - 1)) - 1;
        return n;
    }

    private static int getPrevious(int n) {
        // Counts for zeros and ones
        int zeroCount = 0;
        int oneCount = 0;
        int c = n;
        // Check for trailing ones
        while ((c & 1) == 1) {
            oneCount++;
            c >>= 1;
        }
        // If the number becomes zero, then then return -1
        if (c == 0) {
            return -1;
        }
        // Check for zeros
        while ((c & 1) == 0 && c != 0) {
            zeroCount++;
            c >>= 1;
        }
        // Position of rightmost-non trailing one
        int p = zeroCount + oneCount;
        // Clear all bits from p
        n &= ((~0) << (p + 1));
        // Sequence of (oneCount + 1) ones
        int mask = (1 << (oneCount + 1)) - 1;
        // (oneCount + 1) ones followed by (zeroCount - 1) zeros
        int mask2 = mask << (zeroCount - 1);
        n |= mask2;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(getNext(13948)));
        System.out.println(Integer.toBinaryString(getNext(12)));
        System.out.println(Integer.toBinaryString(getPrevious(13948)));
        System.out.println(Integer.toBinaryString(getPrevious(12)));
    }
}
