package org.redquark.techinterview.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two arrays A and B of size N and M respectively. The task is to find union between these two arrays.
 * Union of the two arrays can be defined as the set containing distinct elements from both the arrays.
 * If there are repetitions, then only one occurrence of element should be printed in union.
 */
public class UnionAndIntersectionOfTwoSortedArrays {

    /**
     * @param a - first array
     * @param b - second array
     * @return - union of two arrays
     */
    private static List<Integer> findUnion(int[] a, int[] b) {
        // List to store union of two arrays
        List<Integer> union = new ArrayList<>();
        // Lengths of two arrays
        int m = a.length;
        int n = b.length;
        // Counters for both arrays
        int i = 0;
        int j = 0;
        // Loop until elements left in either array
        while (i < m && j < n) {
            // If a has smaller element then put it in the list
            if (a[i] < b[j]) {
                union.add(a[i]);
                i++;
                // Handle for duplicate elements
                while (i < m && a[i] == a[i - 1]) {
                    i++;
                }
            }
            // If b has smaller element then put it in the list
            else if (a[i] > b[j]) {
                union.add(b[j]);
                j++;
                // Handle for duplicate elements
                while (j < n && b[j] == b[j - 1]) {
                    j++;
                }
            }
            // If both elements are same, then put either of them
            else {
                union.add(a[i]);
                i++;
                j++;
                // Handle for duplicate elements
                while (i < m && a[i] == a[i - 1]) {
                    i++;
                }
            }
        }
        // Add all remaining elements from a
        while (i < m) {
            union.add(a[i]);
            i++;
            // Handle for duplicate elements
            while (i < m && a[i] == a[i - 1]) {
                i++;
            }
        }
        // Add all remaining elements from b
        while (j < n) {
            union.add(b[j]);
            j++;
            // Handle for duplicate elements
            while (j < n && b[j] == b[j - 1]) {
                j++;
            }
        }
        return union;
    }

    /**
     * @param a - first array
     * @param b - second array
     * @return intersection of two arrays
     */
    private static List<Integer> findIntersection(int[] a, int[] b) {
        // List to store the intersection of two arrays
        List<Integer> intersection = new ArrayList<>();
        // Length of two arrays
        int m = a.length;
        int n = b.length;
        // Indices for two arrays
        int i = 0;
        int j = 0;
        // Loop until there is element left in either array
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                i++;
                // Handle duplicate elements
                while (i < m && a[i] == a[i - 1]) {
                    i++;
                }
            } else if (a[i] > b[j]) {
                j++;
                // Handle duplicate elements
                while (j < n && b[j] == b[j - 1]) {
                    j++;
                }
            } else {
                intersection.add(a[i]);
                i++;
                j++;
                while (i < m && a[i] == a[i - 1]) {
                    i++;
                }
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3};
        System.out.println("Union: " + findUnion(a, b));
        System.out.println("Intersection: " + findIntersection(a, b));

        a = new int[]{1, 2, 3, 4, 5};
        b = new int[]{6, 7, 8};
        System.out.println("Union: " + findUnion(a, b));
        System.out.println("Intersection: " + findIntersection(a, b));

        a = new int[]{1, 1, 1, 1, 1, 1};
        b = new int[]{2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6};
        System.out.println("Union: " + findUnion(a, b));
        System.out.println("Intersection: " + findIntersection(a, b));

        a = new int[]{1, 3, 5, 7, 9};
        b = new int[]{2, 4, 6, 8};
        System.out.println("Union: " + findUnion(a, b));
        System.out.println("Intersection: " + findIntersection(a, b));

        a = new int[]{1, 2, 3, 4, 5, 5, 6};
        b = new int[]{1, 2, 3, 4, 5, 5, 6, 6, 7};
        System.out.println("Union: " + findUnion(a, b));
        System.out.println("Intersection: " + findIntersection(a, b));

        a = new int[]{};
        b = new int[]{};
        System.out.println("Union: " + findUnion(a, b));
        System.out.println("Intersection: " + findIntersection(a, b));
    }
}
