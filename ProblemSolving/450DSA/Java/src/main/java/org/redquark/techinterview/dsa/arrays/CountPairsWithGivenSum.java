package org.redquark.techinterview.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of N integers, and an integer K,
 * find the number of pairs of elements in the array whose sum is equal to K.
 * <p>
 * Constraints:
 * 1 <= N <= 10^5
 * 1 <= K <= 10^8
 * 1 <= a[i] <= 10^6
 */
public class CountPairsWithGivenSum {

    private static int getPairsCount(int[] a, int K) {
        // Count of pairs
        int count = 0;
        // Map to store the frequencies of each element in the array
        Map<Integer, Integer> frequencies = new HashMap<>();
        // Loop for all the elements in the array
        for (int i : a) {
            frequencies.put(i, frequencies.getOrDefault(i, 0) + 1);
        }
        // Traverse the array again to find the pairs
        for (int i : a) {
            if (frequencies.containsKey(K - i)) {
                count += frequencies.get(K - i);
            }
            // For same elements
            if (K - i == i) {
                count--;
            }
        }
        return count / 2;
    }

    public static void main(String[] args) {
        System.out.println(getPairsCount(new int[]{1, 5, 7, 1}, 6));
        System.out.println(getPairsCount(new int[]{1, 1, 1, 1}, 2));
    }
}
