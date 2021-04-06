package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string S delete the characters which are appearing more than once consecutively.
 * <p>
 * Constraints:
 * 1<=|S|<=10^5
 * All characters are lowercase alphabets.
 */
public class RemoveConsecutiveCharacters {

    private static String removeConsecutiveCharacters(String S) {
        // To store the final result
        StringBuilder sb = new StringBuilder();
        // Loop through the string
        for (int i = 0; i < S.length(); i++) {
            sb.append(S.charAt(i));
            while (i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1)) {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "aabb";
        System.out.println(removeConsecutiveCharacters(S));

        S = "aabaa";
        System.out.println(removeConsecutiveCharacters(S));
    }
}
