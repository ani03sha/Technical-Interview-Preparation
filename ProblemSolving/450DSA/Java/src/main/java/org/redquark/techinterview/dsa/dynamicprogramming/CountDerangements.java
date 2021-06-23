package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * A Derangement is a permutation of n elements, such that no element appears in its original position.
 * For example, a derangement of {0, 1, 2, 3} is {2, 3, 1, 0}.
 * <p>
 * Given a number n, find the total number of Derangements of a set of n elements.
 */
public class CountDerangements {

    private static int count(int n) {
        // Lookup table to store derangements for
        // a particular value of n
        int[] lookup = new int[n + 1];
        // Base initialization
        lookup[1] = 0;
        lookup[2] = 1;
        // Populate for remaining places
        for (int i = 3; i <= n; i++) {
            lookup[i] = (i - 1) * (lookup[i - 1] + lookup[i - 2]);
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        System.out.println(count(3));
        System.out.println(count(4));
    }
}
