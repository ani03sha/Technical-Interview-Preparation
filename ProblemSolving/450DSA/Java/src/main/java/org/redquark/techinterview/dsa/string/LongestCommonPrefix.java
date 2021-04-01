package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Constraints:
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] strings) {
        // This variable will store the longest common prefix
        StringBuilder lcp = new StringBuilder();
        // Special cases
        if (strings == null || strings.length == 0) {
            return lcp.toString();
        }
        // Find the length of the shortest string from
        // the array of strings
        int minLength = strings[0].length();
        for (int i = 1; i < strings.length; i++) {
            minLength = Math.min(minLength, strings[i].length());
        }
        // Loop until the minimum length
        for (int i = 0; i < minLength; i++) {
            // Get the current character from first string
            char current = strings[0].charAt(i);
            // Check if this character lies in every string
            // or not
            for (String s : strings) {
                if (s.charAt(i) != current) {
                    return lcp.toString();
                }
            }
            lcp.append(current);
        }
        return lcp.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strings));

        strings = new String[]{"dog", "racecar", "car" };
        System.out.println(longestCommonPrefix(strings));
    }
}
