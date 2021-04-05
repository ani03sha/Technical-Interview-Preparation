package org.redquark.techinterview.dsa.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of strings, return all groups of strings that are anagrams.
 * The groups must be created in order of their appearance in the original array.
 * <p>
 * Constraints:
 * 1<=N<=100
 */
public class GroupAnagrams {

    private static List<List<String>> groupAnagrams(String[] words) {
        // Copy all the words in the array to a list
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        // Sort these words on the list alphabetically
        for (int i = 0; i < wordList.size(); i++) {
            wordList.set(i, words[i]
                    .chars()
                    .sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString());
        }
        // Map to store a word and its corresponding indices
        Map<String, List<Integer>> anagrams = new HashMap<>();
        // Loop through the words array
        for (int i = 0; i < words.length; i++) {
            anagrams.putIfAbsent(wordList.get(i), new ArrayList<>());
            anagrams.get(wordList.get(i)).add(i);
        }
        // Final result
        List<List<String>> result = new ArrayList<>();
        // Loop through the map
        for (Map.Entry<String, List<Integer>> entry : anagrams.entrySet()) {
            // List of words which are anagrams
            List<String> currentWordList = new ArrayList<>();
            for (Integer index : entry.getValue()) {
                currentWordList.add(words[index]);
            }
            result.add(currentWordList);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
                "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
                "SUED", "LEAN", "SCAR", "DESIGN"
        };
        System.out.println(groupAnagrams(words));

        words = new String[]{"CAT", "ACT", "DOG", "TAC", "GOD"};
        System.out.println(groupAnagrams(words));

    }
}
