package org.redquark.techinterview.ctci.arraysandstrings;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings, check if one is permutation of another
 */
public class CheckPermutation {

    private static boolean check(String a, String b) {
        // Check base case
        if (a.length() != b.length()) {
            return false;
        }
        // Array to store the character count
        int[] characterCount = new int[256];
        // Loop through both the strings
        for (int i = 0; i < a.length(); i++) {
            characterCount[a.charAt(i)]++;
            characterCount[b.charAt(i)]--;
        }
        // Loop through the character count array
        for (int i : characterCount) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "";
        String b = "";
        System.out.println(check(a, b));

        a = "cat";
        b = "tac";
        System.out.println(check(a, b));

        a = "abc";
        b = "dba";
        System.out.println(check(a, b));
    }
}
