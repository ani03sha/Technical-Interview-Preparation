package org.redquark.techinterview.dsa.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s find all possible subseqences of the string in lexicographically-sorted order
 */
public class PowerSet {

    private static List<String> possibleSubsequences(String s) {
        // List to store the result
        List<String> result = new ArrayList<>();
        // Map to store string lexicographically
        SortedMap<Integer, List<String>> sortedSubsequences = new TreeMap<>();
        // Length of the string
        int n = s.length();
        // Total number of non-empty subsequences
        int limit = (int) (Math.pow(2, n) - 1);
        // Loop through every combination
        for (int i = 1; i <= limit; i++) {
            String subSequence = getSubsequence(s, i, n);
            // Storing this subsequence in map
            if (!sortedSubsequences.containsKey(subSequence.length())) {
                sortedSubsequences.put(subSequence.length(), new ArrayList<>());
            }
            sortedSubsequences.get(subSequence.length()).add(subSequence);
        }
        // Populate the resultant list
        for (Map.Entry<Integer, List<String>> entry : sortedSubsequences.entrySet()) {
            result.addAll(entry.getValue());
        }
        Collections.sort(result);
        return result;
    }

    private static String getSubsequence(String s, int index, int n) {
        StringBuilder subSequence = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // Check if i-th bit in index is 1
            if ((index & (1 << i)) != 0) {
                subSequence.append(s.charAt(i));
            }
        }
        return subSequence.toString();
    }

    public static void main(String[] args) {
        System.out.println(possibleSubsequences("abc"));
        System.out.println(possibleSubsequences("axz"));
    }
}
