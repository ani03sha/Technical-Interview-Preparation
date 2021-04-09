package org.redquark.techinterview.ctci.arraysandstrings;

/**
 * @author Anirudh Sharma
 * <p>
 * There can be three types of edits that can be performed on a strings: insert a character,
 * remove a character or replace a character.
 * <p>
 * Given two strings, check if they are one edit (or zero edits) away.
 */
public class OneAway {

    private static boolean checkIfAway(String a, String b) {
        // Array to store the frequencies of characters
        int[] frequencyMap = new int[256];
        // Index to iterate through the strings
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            frequencyMap[a.charAt(i)]++;
            frequencyMap[b.charAt(j)]--;
            i++;
            j++;
        }
        // For remaining characters in the string
        while (i < a.length()) {
            frequencyMap[a.charAt(i)]++;
            i++;
        }
        while (j < b.length()) {
            frequencyMap[b.charAt(j)]--;
            j++;
        }
        // Non zero frequencies
        int nonZeroFrequency = 0;
        // Scan the frequency map again
        for (int frequency : frequencyMap) {
            if (frequency != 0) {
                nonZeroFrequency++;
                if (nonZeroFrequency > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "pale";
        String b = "ple";
        System.out.println(checkIfAway(a, b));

        a = "pales";
        b = "pale";
        System.out.println(checkIfAway(a, b));

        a = "pale";
        b = "bale";
        System.out.println(checkIfAway(a, b));

        a = "pale";
        b = "bake";
        System.out.println(checkIfAway(a, b));

        a = "pele";
        b = "beke";
        System.out.println(checkIfAway(a, b));

        a = "apple";
        b = "aple";
        System.out.println(checkIfAway(a, b));
    }
}
