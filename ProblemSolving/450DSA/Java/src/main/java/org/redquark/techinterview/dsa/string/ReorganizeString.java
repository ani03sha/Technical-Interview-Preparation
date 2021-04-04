package org.redquark.techinterview.dsa.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent
 * to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Note:
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReorganizeString {

    private static String reorganizeString(String S) {
        // Get the frequencies of each character
        // in the string
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : S.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        // Create a max heap using priority queue
        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        // Add all the keys of the frequencyMap in  the priority queue
        maxHeap.addAll(frequencyMap.keySet());
        // String Builder to store the result
        StringBuilder result = new StringBuilder();
        // Loop until only one element is remaining in the heap
        while (maxHeap.size() > 1) {
            // Most frequent character
            char mostFrequentCharacter = maxHeap.remove();
            // Second most frequent character
            char secondMostFrequentCharacter = maxHeap.remove();
            // Add these to the result
            result.append(mostFrequentCharacter).append(secondMostFrequentCharacter);
            // Update the counts of these characters in the map
            frequencyMap.put(mostFrequentCharacter, frequencyMap.get(mostFrequentCharacter) - 1);
            frequencyMap.put(secondMostFrequentCharacter, frequencyMap.get(secondMostFrequentCharacter) - 1);
            // If their counts is greater than zero, we need to
            // put them back in the heap
            if (frequencyMap.get(mostFrequentCharacter) > 0) {
                maxHeap.add(mostFrequentCharacter);
            }
            if (frequencyMap.get(secondMostFrequentCharacter) > 0) {
                maxHeap.add(secondMostFrequentCharacter);
            }
        }
        // Get the last character in the heap
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            // check if we can create the string
            if (frequencyMap.get(last) > 1) {
                return "";
            }
            result.append(last);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}
