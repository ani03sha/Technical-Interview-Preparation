package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary string str of length N, the task is to find the maximum count of substrings 's'
 * can be divided into such that all the substrings are balanced i.e. they have equal number of 0s and 1s.
 * <p>
 * If it is not possible to split str satisfying the conditions then print -1.
 */
public class SplitBinaryString {

    private static int countOfBalancedSubstrings(String s) {
        // Count of ones and zeros in the string
        int zeroCount = 0;
        int oneCount = 0;
        // Count of balanced substrings
        int count = 0;
        // Loop through the entire string
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroCount++;
            } else if (c == '1') {
                oneCount++;
            }
            if (zeroCount == oneCount) {
                count++;
            }
        }
        return zeroCount == oneCount ? count : -1;
    }

    public static void main(String[] args) {
        System.out.println(countOfBalancedSubstrings("0100110101"));
        System.out.println(countOfBalancedSubstrings("0111100010"));
    }
}
