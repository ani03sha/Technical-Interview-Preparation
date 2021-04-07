package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings A and B, the task is to convert A to B if possible.
 * The only operation allowed is to put any character from A and insert it at front.
 * <p>
 * Find if it’s possible to convert the string. If yes, then output minimum no. of operations
 * required for transformation.
 */
public class TransformOneStringToAnother {

    private static int minimumOperations(String A, String B) {
        // Base checks for possible conversions
        if (A.length() != B.length()) {
            return -1;
        }
        // Frequency map of characters in both strings
        int[] frequencyMap = new int[256];
        // Loop through both strings
        for (int i = 0; i < A.length(); i++) {
            frequencyMap[A.charAt(i)]++;
            frequencyMap[B.charAt(i)]--;
        }
        // If frequency of any character is not zero,
        // then we know that conversion is not possible
        for (int i : frequencyMap) {
            if (i != 0) {
                return -1;
            }
        }
        // Count of operations needed
        int count = 0;
        // Variables to iterate through both strings
        int i = A.length() - 1;
        int j = B.length() - 1;
        // Loop from right to left
        while (i >= 0) {
            // If the characters don't match,
            // keep incrementing count
            if (A.charAt(i) != B.charAt(j)) {
                count++;
            } else {
                j--;
            }
            i--;
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "EACBD";
        String B = "EABCD";
        System.out.println(minimumOperations(A, B));

        A = "ABD";
        B = "BAD";
        System.out.println(minimumOperations(A, B));
    }
}
