package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary string of 0s and 1s. The task is to find the maximum difference of the number
 * of 0s and the number of 1s (number of 0s – number of 1s) in the substrings of a string.
 * <p>
 * Note: In the case of all 1s, the answer will be -1.
 */
public class MaximumDifferenceOfZerosAndOnes {

    private static int maxDifference(String s) {
        // Special case
        if (s == null || s.isEmpty() || checkIfAllOnes(s)) {
            return -1;
        }
        // Length of the String
        int n = s.length();
        // Array containing the integer values
        int[] nums = new int[n];
        // Fill this array => -1 for '1' and 1 for '0'
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) == '0' ? 1 : -1;
        }
        // Lookup table to store two cases
        // lookup[i][0] -> maxDifference up to i, if we skip i-th element
        // lookup[i][1] -> maxDifference up to i, if we consider i-th element
        int[][] lookup = new int[n][2];
        // Fill this array with the default value
        for (int[] row : lookup) {
            Arrays.fill(row, -1);
        }
        return findLength(nums, n, 0, 0, lookup);
    }

    private static int findLength(int[] nums, int n, int index, int choice, int[][] lookup) {
        // If we have reached the end of the string
        if (index >= n) {
            return 0;
        }
        // If we already have calculated the state
        if (lookup[index][choice] != -1) {
            return lookup[index][choice];
        }
        if (choice == 0) {
            return lookup[index][choice] = Math.max(
                    nums[index] + findLength(nums, n, index + 1, 1, lookup),
                    findLength(nums, n, index + 1, 0, lookup));
        } else {
            return lookup[index][choice] = Math.max(
                    nums[index] + findLength(nums, n, index + 1, 1, lookup),
                    0);
        }
    }

    private static boolean checkIfAllOnes(String s) {
        // Count of ones
        int oneCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                oneCount++;
            }
        }
        return oneCount == s.length();
    }

    public static void main(String[] args) {
        System.out.println(maxDifference("11000010001"));
        System.out.println(maxDifference("111111"));
    }
}
