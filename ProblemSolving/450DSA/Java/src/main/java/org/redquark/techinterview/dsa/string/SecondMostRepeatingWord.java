package org.redquark.techinterview.dsa.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sequence of strings, the task is to find out the second most repeated (or frequent)
 * string in the given sequence.
 * <p>
 * Note: No two strings are the second most repeated, there will be always a single string.
 * <p>
 * Constraints:
 * 1<=N<=10^3
 */
public class SecondMostRepeatingWord {

    private static String secondMostFrequent(String[] strings) {
        // Map to store the frequencies of strings
        // in the array
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String s : strings) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        // Max and second max
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        // Loop through the map to find the second map value
        for (int i : frequencyMap.values()) {
            if (max < i) {
                secondMax = max;
                max = i;
            } else if (i > secondMax && i != max) {
                secondMax = i;
            }
        }
        // Again iterate through the map to get the key
        // corresponding to the the second max value
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == secondMax) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"aaa", "bbb", "ccc", "bbb", "aaa", "aaa" };
        System.out.println(secondMostFrequent(strings));

        strings = new String[]{"geek", "for", "geek", "for", "geek", "aaa" };
        System.out.println(secondMostFrequent(strings));
    }
}
