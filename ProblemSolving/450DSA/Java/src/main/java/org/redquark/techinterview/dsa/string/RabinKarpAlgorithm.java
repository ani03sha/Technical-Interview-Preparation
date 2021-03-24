package org.redquark.techinterview.dsa.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a text t[0..n-1] and a pattern p[0..m-1], write a function search(char p[], char t[])
 * that prints all occurrences of p[] in t[]. You may assume that n > m.
 */
public class RabinKarpAlgorithm {

    // Maximum number of characters in the input
    private static final int d = 256;
    // A prime number to manipulate the hash
    private static final int q = 257;

    private static List<Integer> search(String pattern, String text) {
        // List to store the indices where pattern starts
        List<Integer> indices = new ArrayList<>();
        // Lengths of pattern and text
        int patternLength = pattern.length();
        int textLength = text.length();
        // Hashes to pattern and text
        int patternHash = 0;
        int textHash = 0;
        // To determine higher order position
        int h = 1;
        for (int i = 0; i < patternLength - 1; i++) {
            h = (h * d) % q;
        }
        // Find hash of the pattern and first window of
        // length patternLength in the text
        for (int i = 0; i < patternLength; i++) {
            patternHash = (d * patternHash + pattern.charAt(i)) % q;
            textHash = (d * textHash + text.charAt(i)) % q;
        }
        // Perform sliding window matching on text
        for (int i = 0; i <= textLength - patternLength; i++) {
            // If the hashes match, then only we will match the
            // characters of both the strings
            if (patternHash == textHash) {
                // Check for characters one by one
                for (int j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                indices.add(i);
            }
            // Calculate the hash for the next window
            if (i < textLength - patternLength) {
                textHash = (d * (textHash - text.charAt(i) * h) + text.charAt(i + patternLength)) % q;
                // For negative value of textHash, convert it to positive
                if (textHash < 0) {
                    textHash += q;
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        String text = "ABCCDDAEFG";
        String pattern = "CDD";
        System.out.println(search(pattern, text));

        text = "12348765765";
        pattern = "765";
        System.out.println(search(pattern, text));

        text = "balloonsandcupcakes";
        pattern = "cupcakes";
        System.out.println(search(pattern, text));
    }
}
