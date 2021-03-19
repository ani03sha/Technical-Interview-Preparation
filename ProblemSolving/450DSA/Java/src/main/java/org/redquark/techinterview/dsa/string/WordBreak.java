package org.redquark.techinterview.dsa.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s, and a dictionary of n words wordDictionary,
 * find out if A can be segmented into a space-separated sequence of dictionary words.
 * <p>
 * 1 <= N <= 12
 * 1 <= s <= 1000, where s = length of string A
 * The length of each word is less than 15.
 */
public class WordBreak {

    private static boolean wordBreak(String s, List<String> wordDictionary) {
        // Lookup for memoization
        Map<String, Boolean> lookup = new HashMap<>();
        return wordBreakHelper(s, wordDictionary, lookup);
    }

    private static boolean wordBreakHelper(String s, List<String> wordDictionary, Map<String, Boolean> lookup) {
        // Base case
        if (s == null || s.isEmpty()) {
            return true;
        }
        // Check if the subproblem is already solved
        if (lookup.containsKey(s)) {
            return lookup.get(s);
        }
        // Loop for every word in the dictionary
        for (String word : wordDictionary) {
            // Check if current word is the starting
            // word of the string
            if (s.startsWith(word)) {
                // Get the remaining word
                String suffix = s.substring(word.length());
                if (wordBreakHelper(suffix, wordDictionary, lookup)) {
                    lookup.put(s, true);
                    return true;
                }
            }
        }
        lookup.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "ilike";
        List<String> wordDictionary = Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile",
                "ice", "cream", "icecream", "man", "go", "mango");
        System.out.println(wordBreak(s, wordDictionary));

        s = "ilikesamsung";
        wordDictionary = Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile",
                "ice", "cream", "icecream", "man", "go", "mango");
        System.out.println(wordBreak(s, wordDictionary));
    }
}
