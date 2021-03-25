package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a text t[0..n-1] and a pattern p[0..m-1], write a function search(char p[], char t[])
 * that prints all occurrences of p[] in t[]. You may assume that n > m.
 */
public class KMPAlgorithm {

    private static boolean search(String pattern, String text) {
        // Prepare the pi table of prefix-suffix table
        int[] lps = findLPS(pattern);
        // Indices to move through text and pattern
        // respectively
        int textIndex = 0;
        int patternIndex = 0;
        // Loop until we reach to the end
        while (textIndex < text.length() && patternIndex < pattern.length()) {
            // If the characters match
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;
            } else {
                if (patternIndex != 0) {
                    patternIndex = lps[patternIndex - 1];
                } else {
                    textIndex++;
                }
            }
        }
        return patternIndex == pattern.length();
    }

    private static int[] findLPS(String pattern) {
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
        String text = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        System.out.println("Does pattern exist? " + search(pattern, text));
    }
}
