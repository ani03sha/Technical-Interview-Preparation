package org.redquark.techinterview.mustdolc75;

/**
 * @author Anirudh Sharma
 * <p>
 * LeetCode #5 - https://leetcode.com/problems/longest-palindromic-substring/ (MEDIUM)
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return "";
        }
        // Start and end indices of the palindrome
        int start = 0;
        int end = 0;
        // Loop through the string character by character
        for (int i = 0; i < s.length(); i++) {
            // For odd length strings
            int a = expandFromCenter(s, i, i);
            // For event length strings
            int b = expandFromCenter(s, i, i + 1);
            // Find the maximum of the two
            int length = Math.max(a, b);
            // Update the start and end pointers, if required.
            // This step is needed so that we can find the
            // appropriate substring at the end.
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int start, int end) {
        // Base case
        if (s == null || start > end) {
            return 0;
        }
        // Check for the palindromic property
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }
}
