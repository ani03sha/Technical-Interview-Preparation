package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s we need to tell minimum characters to be added at front of string to make string palindrome.
 */
public class MinimumCharactersAtFrontToMakePalindrome {

    private static int getCount(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        // Reversed String
        String reversedString = sb.reverse().toString();
        // Add this reverse string to the original string with
        // a special character
        sb.reverse().append("$").append(reversedString);
        // Get the LPS array
        int[] lps = getLPS(sb.toString());
        return s.length() - lps[sb.length() - 1];
    }

    private static int[] getLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        // Index for checking the pattern
        int index = 0;
        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(getCount("AACECAAAA"));
        System.out.println(getCount("ABC"));
    }
}
