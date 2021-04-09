package org.redquark.techinterview.ctci.arraysandstrings;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * The palindrome doesn't need to be limited to the dictionary words.
 */
public class PalindromePermutation {

    private static boolean isPermutationPalindrome(String s) {
        // Array to store the frequencies of the characters
        // in the string
        int[] frequencyMap = new int[256];
        // Loop through the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                frequencyMap[s.charAt(i)]++;
            }
        }
        // Count of characters with frequency equal to 1
        int charactersWithSingleOccurrence = 0;
        // Loop through the frequency map again
        for (int frequency : frequencyMap) {
            if (frequency % 2 == 1) {
                charactersWithSingleOccurrence++;
                if (charactersWithSingleOccurrence > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationPalindrome("tact coa"));
        System.out.println(isPermutationPalindrome("aabcb"));
        System.out.println(isPermutationPalindrome("abcb"));
        System.out.println(isPermutationPalindrome("ababcc"));
    }
}
