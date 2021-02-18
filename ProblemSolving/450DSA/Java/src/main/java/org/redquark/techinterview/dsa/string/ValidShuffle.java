package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Check if a string is the valid shuffle of two other strings.
 * In order to be a valid shuffle, the order of string should be maintained.
 */
public class ValidShuffle {

    private static boolean checkIfValidShuffle(String a, String b, String c) {
        // Check if sum of lengths of a and b is equal to
        // the length of c.
        if (a.length() + b.length() != c.length()) {
            return false;
        }
        // Pointers to iterate through different strings
        int i = 0;
        int j = 0;
        int k = 0;
        // Loop until k reaches the end of c
        while (k < c.length()) {
            // Check if the character of a matches with
            // the character of c
            if (i < a.length() && a.charAt(i) == c.charAt(k)) {
                i++;
            }
            // Check if character of b matches with
            // the character of c
            else if (j < b.length() && b.charAt(j) == c.charAt(k)) {
                j++;
            }
            // If none of the characters match
            else {
                return false;
            }
            k++;
        }
        // Check if there are remaining characters in a or b
        return i >= a.length() && j >= b.length();
    }

    public static void main(String[] args) {
        String a = "XY";
        String b = "12";
        String c = "1XY2";
        System.out.println(checkIfValidShuffle(a, b, c));

        c = "Y12X";
        System.out.println(checkIfValidShuffle(a, b, c));
    }
}
