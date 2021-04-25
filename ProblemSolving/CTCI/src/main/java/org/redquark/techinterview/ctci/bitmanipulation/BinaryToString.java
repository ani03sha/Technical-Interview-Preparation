package org.redquark.techinterview.ctci.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
 * <p>
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR:'
 */
public class BinaryToString {

    private static String binaryToString(double n) {
        // Check for the base cases
        if (n >= 1 || n < 0) {
            return "ERROR";
        }
        // String to store result
        StringBuilder result = new StringBuilder();
        // The first position in the output will be
        // a decimal point
        result.append(".");
        // Loop until the number is greater than 0
        while (n > 0) {
            // Check for length overflow
            if (result.length() >= 32) {
                return "ERROR";
            }
            // Left shift by one position
            double r = 2 * n;
            // Check for the whole part
            if (r >= 1) {
                result.append(1);
                n = r - 1;
            } else {
                result.append(0);
                n = r;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        double n = 0.72;
        System.out.println(binaryToString(n));

        n = 0.625;
        System.out.println(binaryToString(n));

        n = 0.78125;
        System.out.println(binaryToString(n));

        n = 0.34375;
        System.out.println(binaryToString(n));
    }
}
