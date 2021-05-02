package org.redquark.techinterview.mustdolc75;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anirudh Sharma
 * <p>
 * LeetCode #3 - https://leetcode.com/problems/longest-substring-without-repeating-characters (MEDIUM)
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // Variable to store longest length
        int maxLength = 0;
        // Set to keep track of characters which
        // we have encountered so far
        Set<Character> encounteredCharacters = new HashSet<>();
        // Slow and fast pointers for sliding window
        int slow = 0;
        int fast = 0;
        // Loop through the string character by character
        while (fast < s.length()) {
            // Try to add current element at fast in the set
            if (encounteredCharacters.add(s.charAt(fast))) {
                // Update the fast pointer
                fast++;
                // Calculate new maximum
                maxLength = Math.max(encounteredCharacters.size(), maxLength);
            } else {
                // Remove character from the left and move slow
                encounteredCharacters.remove(s.charAt(slow));
                slow++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
