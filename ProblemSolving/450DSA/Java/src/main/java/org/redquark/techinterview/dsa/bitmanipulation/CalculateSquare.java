package org.redquark.techinterview.dsa.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer n, calculate the square of a number without using *, / and pow().
 */
public class CalculateSquare {

    private static int findSquare(int n) {
        // Special case
        if (n == 0) {
            return 0;
        }
        // For negative numbers
        if (n < 0) {
            n = -n;
        }
        // Get floor(n/2) using right shift
        int x = n >> 1;
        // Check for even and odd
        if (n % 2 == 0) {
            return (findSquare(x) << 2);
        } else {
            return ((findSquare(x) << 2)) + (x << 2) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findSquare(5));
        System.out.println(findSquare(38));
        System.out.println(findSquare(-63));
    }
}
