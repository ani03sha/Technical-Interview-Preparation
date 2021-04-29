package org.redquark.techinterview.dsa.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a two integers say a and b, find the quotient after dividing a by b without
 * using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {

    private static long divide(long a, long b) {
        // Sign of the quotient
        long sign = (a < 0) ^ (b < 0) ? -1 : 1;
        // Get the absolute values
        a = Math.abs(a);
        b = Math.abs(b);
        // Quotient
        int quotient = 0;
        int sum = 0;
        for (int i = 31; i >= 0; i--) {
            if (sum + (b << i) <= a) {
                // Update the current sum
                sum += (b << i);
                // Update the quotient
                quotient |= (1L << i);
            }
        }
        return quotient * sign;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(-43, 8));
    }
}
