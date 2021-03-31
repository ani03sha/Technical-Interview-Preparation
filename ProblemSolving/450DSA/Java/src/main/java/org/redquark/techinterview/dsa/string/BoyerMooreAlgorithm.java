package org.redquark.techinterview.dsa.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
 * search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].
 */
public class BoyerMooreAlgorithm {

    private static List<Integer> search(String pattern, String text) {
        // List to store the indices of match
        List<Integer> matchedIndices = new ArrayList<>();
        // Lengths of pattern and text
        int patternLength = pattern.length();
        int textLength = text.length();
        // Array for storing the indices of bad characters
        int[] badCharacters = new int[256];
        // Fill the badCharacters array using preprocessing
        // bad character heuristics function
        badCharacterHeuristics(pattern, patternLength, badCharacters);
        // Shift of the pattern w.r.t. text
        int shift = 0;
        // Loop through the text string
        while (shift <= textLength - patternLength) {
            // Pointer to move from right of the pattern
            int right = patternLength - 1;
            // Move from left to right as long as the
            // characters of pattern are matching with
            // the characters of text
            while (right >= 0 && pattern.charAt(right) == text.charAt(shift + right)) {
                right--;
            }
            // If the pattern is present at the current shift,
            // then right will become -1
            if (right < 0) {
                matchedIndices.add(shift);
                // Shift the pattern so that next character in text
                // aligns with the last occurrence of it in the pattern
                shift += (shift + patternLength < textLength)
                        ? patternLength - badCharacters[text.charAt(shift + patternLength)]
                        : 1;
            } else {
                // Shift the pattern so that the bad character
                // in text aligns with the last occurrence of
                // it in pattern. The max function is used to
                // make sure that we get a positive shift.
                // We may get a negative shift if the last
                // occurrence  of bad character in pattern
                // is on the right side of the current
                // character
                shift += Math.max(1, right - badCharacters[text.charAt(shift + right)]);
            }
        }
        return matchedIndices;
    }

    private static void badCharacterHeuristics(String pattern, int patternLength, int[] badCharacters) {
        // Fill the array with -1
        Arrays.fill(badCharacters, -1);
        // Fill actual value of last occurrence of a character
        for (int i = 0; i < patternLength; i++) {
            badCharacters[pattern.charAt(i)] = i;
        }
    }

    public static void main(String[] args) {
        String text = "ABAAABCD";
        String pattern = "ABC";
        System.out.println(search(pattern, text));

        text = "ACAAAABAAAACAAABAAAACAA";
        pattern = "AAAA";
        System.out.println(search(pattern, text));
    }
}
