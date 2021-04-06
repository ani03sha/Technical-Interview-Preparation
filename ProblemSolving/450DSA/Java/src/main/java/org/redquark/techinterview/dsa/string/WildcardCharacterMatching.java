package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings where first string may contain wild card characters and second string
 * is a normal string.
 * <p>
 * Write a function that returns true if the two strings match.
 * The following are allowed wild card characters in first string.
 * <p>
 * - * --> Matches with 0 or more instances of any character or set of characters.
 * - ? --> Matches with any one character.
 */
public class WildcardCharacterMatching {

    private static boolean match(String first, String second) {
        // Base case - if we reach to the end of
        // both strings, we are done
        if (first.length() == 0 && second.length() == 0) {
            return true;
        }
        // Make sure the characters after '*' are present
        // in the second string
        if (first.length() > 1 && first.charAt(0) == '*' && second.length() == 0) {
            return false;
        }
        // If the first string contains '?',
        // or current characters of both strings match
        if ((first.length() > 1 && first.charAt(0) == '?')
                || first.length() != 0 && second.length() != 0 && first.charAt(0) == second.charAt(0)) {
            return match(first.substring(1), second.substring(1));
        }
        // If there is *, then there are two possibilities
        // a) We consider current character of second string
        // b) We ignore current character of second string.
        if (first.length() > 0 && first.charAt(0) == '*') {
            return match(first.substring(1), second) ||
                    match(first, second.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(match("*pqrs", "pqrst"));
        System.out.println(match("abc*bcd", "abcdhghgbcd"));
        System.out.println(match("abc*c?d", "abcd"));
        System.out.println(match("*c*d", "abcd"));
        System.out.println(match("*?c*d", "abcd"));
    }
}
