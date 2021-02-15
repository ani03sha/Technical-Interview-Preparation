package org.redquark.techinterview.dsa.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Write an efficient program to print all the duplicates and their counts in the input string.
 */
public class DuplicateCharacters {

    private static void printDuplicateCharacters(String s) {
        // Map to store the count of the characters
        Map<Character, Integer> characterCount = new HashMap<>();
        // Loop through the entire string
        for (char c : s.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }
        // Loop through the map to show the duplicate characters
        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Character: " + entry.getKey() + " Count: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        String s = "test string";
        printDuplicateCharacters(s);

        s = "thisstringcontainsmanyduplicatecharacters";
        printDuplicateCharacters(s);
    }
}
