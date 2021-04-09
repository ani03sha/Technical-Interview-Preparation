package org.redquark.techinterview.ctci.arraysandstrings;

/**
 * @author Anirudh Sharma
 * <p>
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * <p>
 * Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat" ).
 */
public class StringRotation {

    private static boolean isRotation(String a, String b) {
        return a.length() == b.length() && (a + a).contains(b);
    }

    public static void main(String[] args) {
        String a = "waterbottle";
        String b = "erbottlewat";
        System.out.println(isRotation(a, b));

        a = "ABCD";
        b = "CDAB";
        System.out.println(isRotation(a, b));

        a = "ABCD";
        b = "ACBD";
        System.out.println(isRotation(a, b));
    }
}
