package org.redquark.techinterview.dsa.dynamicprogramming;


public class LongestAlternatingSubsequence {

    private static int longestAlternatingSubsequence(int[] nums) {
        // Length of the longest wiggle subsequence
        int longestWiggleSubsequence = 1;
        // Sign of the difference of alternating numbers
        int lastSign = 0;
        // Loop from the second element to the end
        for (int i = 1; i < nums.length; i++) {
            int currentSign = getSign(nums[i] - nums[i - 1]);
            if (currentSign != 0 && currentSign != lastSign) {
                lastSign = currentSign;
                longestWiggleSubsequence++;
            }
        }
        return longestWiggleSubsequence;
    }

    private static int getSign(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n > 0 ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 4};
        System.out.println(longestAlternatingSubsequence(nums));

        nums = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(longestAlternatingSubsequence(nums));
    }
}
