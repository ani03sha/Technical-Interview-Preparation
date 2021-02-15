package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
 * (eg given s1 = ABCD and s2 = CDAB, returns true, given s1 = ABCD, and s2 = ACBD , returns false)
 */
public class CheckIfAStringIsRotationOfOther {

    private static boolean checkIfRotation(String s1, String s2) {
        return (s1.length() == s2.length() && (s1 + s1).contains(s2));
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";
        System.out.println(checkIfRotation(s1, s2));

        s2 = "ACBD";
        System.out.println(checkIfRotation(s1, s2));
    }
}
