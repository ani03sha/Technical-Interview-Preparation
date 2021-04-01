package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary string, that is it contains only 0s and 1s. We need to make this string a
 * sequence of alternate characters by flipping some of the bits, our goal is to minimize
 * the number of bits to be flipped.
 * <p>
 * Constraints:
 * 1<=|S|<=10^5
 */
public class MinimumFlipsToMakeBinaryStringAlternate {

    private static int minimumFlips(String s) {
        return Math.min(getFlips(s, '0'), getFlips(s, '1'));
    }

    private static int getFlips(String s, char expected) {
        // Count of flips to make
        int flips = 0;
        // Loop through the entire string
        for (int i = 0; i < s.length(); i++) {
            // If the character is not expected,
            // increment the flips
            if (s.charAt(i) != expected) {
                flips++;
            }
            // Update the expected character
            expected = expected == '0' ? '1' : '0';
        }
        return flips;
    }

    public static void main(String[] args) {
        String s = "001";
        System.out.println(minimumFlips(s));

        s = "0001010111";
        System.out.println(minimumFlips(s));
    }
}
