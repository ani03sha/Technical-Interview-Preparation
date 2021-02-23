package org.redquark.techinterview.dsa.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string S. The task is to print all permutations of a given string.
 * <p>
 * onstraints:
 * 1 ≤ T ≤ 10
 * 1 ≤ size of string ≤ 5
 */
public class AllPermutations {

    private static List<String> findPermutations(String s) {
        // List to store the result
        List<String> permutations = new ArrayList<>();
        // Recursive function
        findPermutations(s, "", permutations);
        return permutations;
    }

    private static void findPermutations(String s, String prefix, List<String> permutations) {
        // Get the length of the string
        int n = s.length();
        // Special case
        if (n == 0) {
            permutations.add(prefix);
            return;
        }
        for (int i = 0; i < n; i++) {
            findPermutations(s.substring(0, i) + s.substring(i + 1, n), prefix + s.charAt(i), permutations);
        }
    }

    public static void main(String[] args) {
        System.out.println(findPermutations("ABC"));
        System.out.println(findPermutations("ABSG"));
    }
}
