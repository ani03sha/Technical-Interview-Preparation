package org.redquark.techinterview.ctci.arraysandstrings;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * <p>
 * For example, the string aabcccccaaa would become a2b1c5a3. If the compressed" string would not
 * become smaller than the original string, your method should return the original string.
 * <p>
 * You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    private static String compress(String s) {
        // Base checks
        if (s == null || s.isEmpty()) {
            return s;
        }
        // Final result
        StringBuilder compressedString = new StringBuilder();
        // Count of same consecutive characters
        int count = 1;
        // Loop through the entire string
        for (int i = 0; i < s.length(); i++) {
            // Character at the i-th place
            char c = s.charAt(i);
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            compressedString.append(c).append(count);
            count = 1;
        }
        return s.length() < compressedString.length() ? s : compressedString.toString();
    }

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(compress(s));

        s = "abc";
        System.out.println(compress(s));

        s = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
        System.out.println(compress(s));
    }
}
