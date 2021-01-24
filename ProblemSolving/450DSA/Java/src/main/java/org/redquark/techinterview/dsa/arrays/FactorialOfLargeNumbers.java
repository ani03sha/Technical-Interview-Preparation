package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer, the task is to find factorial of the number.
 */
public class FactorialOfLargeNumbers {

    private static int[] findFactorial(int n) {
        // The array to store the digits of factorial
        int[] factorial = new int[2568];
        // Initialize the result
        factorial[0] = 1;
        // Number of digits
        int digits = 1;
        // Loop for 2 to n
        for (int i = 2; i <= n; i++) {
            digits = multiply(i, factorial, digits);
        }
        return Arrays.copyOfRange(factorial, 0, digits);
    }

    private static int multiply(int value, int[] factorial, int digits) {
        // Carry
        int carry = 0;
        // Multiply i with every element of factorial
        for (int i = 0; i < digits; i++) {
            // Product with current element
            int product = factorial[i] * value + carry;
            factorial[i] = product % 10;
            carry = product / 10;
        }
        // Put carry in factorial and increase digits
        while (carry != 0) {
            factorial[digits] = carry % 10;
            carry /= 10;
            digits++;
        }
        return digits;
    }

    private static void print(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(findFactorial(10));
        print(findFactorial(50));
        print(findFactorial(100));
        print(findFactorial(500));
        print(findFactorial(1000));
    }
}
