package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s, find number of palindromic subsequence (need not necessarily be distinct)
 * which could be formed from the string.
 */
public class CountPalindromicSubsequences {

    private static long countPalindromicSubsequences(String s) {
        // Count of all the palindromic subsequences
        long count = 0;
        // Loop through the string
        for (int i = 0; i < s.length(); i++) {
            // For odd length string, expand from s[i]
            count += expandFromMiddle(s, i, i);
            // For even length string, expand from s[i]
            // and s[i+1]
            count += expandFromMiddle(s, i, i + 1);
        }
        return count;
    }

    private static long expandFromMiddle(String s, int left, int right) {
        long count = 0;
        // Check for the equality
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // Increment the count
            count++;
            // Expand from both sides
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequences("abcd"));
        System.out.println(countPalindromicSubsequences("aab"));
        System.out.println(countPalindromicSubsequences("aaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
