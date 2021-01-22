package org.redquark.techinterview.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
 * Note: can you take care of the duplicates without using any additional Data Structure?
 * <p>
 * Constraints:
 * 1 <= n1, n2, n3 <= 10^5
 * The array elements can be both positive or negative integers.
 */
public class CommonElementsInThreeSortedArrays {

    private static List<Integer> commonElements(int[] A, int[] B, int[] C) {
        // List to store the common elements
        List<Integer> commons = new ArrayList<>();
        // Indices to traverse through the three arrays
        int i = 0;
        int j = 0;
        int k = 0;
        // Loop until there are elements in every array
        while (i < A.length && j < B.length && k < C.length) {
            // If the current element in all the three arrays is equal
            // then we will add it to the result
            if (A[i] == B[j] && B[j] == C[k]) {
                // To avoid duplicates
                if (!commons.contains(A[i])) {
                    commons.add(A[i]);
                }
                i++;
                j++;
                k++;
            }
            // If current element in A is less than the current element
            // in B, the we will move A ahead as the array is sorted
            // so the next common element will be ahead of the current
            // element, if exists
            else if (A[i] < B[j]) {
                i++;
            }
            // If current element in B is less than the current element
            // in C, the we will move B ahead as the array is sorted
            // so the next common element will be ahead of the current
            // element, if exists
            else if (B[j] < C[k]) {
                j++;
            }
            // We will move C ahead
            else {
                k++;
            }
        }
        return commons;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 10, 20, 40, 80};
        int[] B = new int[]{6, 7, 20, 80, 100};
        int[] C = new int[]{3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(commonElements(A, B, C));

        A = new int[]{3, 3, 3};
        B = new int[]{3, 3, 3};
        C = new int[]{3, 3, 3};
        System.out.println(commonElements(A, B, C));
    }
}
