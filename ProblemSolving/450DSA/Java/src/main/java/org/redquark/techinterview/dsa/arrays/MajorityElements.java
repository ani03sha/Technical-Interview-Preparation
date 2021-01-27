package org.redquark.techinterview.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of size n, find all elements in array that appear more than n/k times.
 */
public class MajorityElements {

    private static List<Integer> findElements(int[] nums, int k) {
        // Special cases
        if (nums == null || nums.length < 1) {
            return Collections.emptyList();
        }
        // Length of the array
        int n = nums.length;
        // List to store the result
        List<Integer> result = new ArrayList<>();
        if (k < 2) {
            for (int num : nums) {
                result.add(num);
            }
            return result;
        }
        // Create an array of size k - 1 of type Element.
        // The number of elements in the output cannot be
        // more than k - 1
        Element[] elements = new Element[k - 1];
        // Fill the array and set count of every element 0
        for (int i = 0; i < k - 1; i++) {
            elements[i] = new Element();
            elements[i].count = 0;
        }
        // Process all elements in the given array
        for (int num : nums) {
            // If current element nums[i] is already
            // present in the array then increment
            // its count
            int j;
            for (j = 0; j < k - 1; j++) {
                if (num == elements[j].value) {
                    elements[j].count += 1;
                    break;
                }
            }
            // If the current element is not present in the
            // elements array
            if (j == k - 1) {
                // If there is position available in elements
                // then place nums[i] there and set its count
                // to 1.
                int l;
                for (l = 0; l < k - 1; l++) {
                    if (elements[l].count == 0) {
                        elements[l].value = num;
                        elements[l].count = 1;
                        break;
                    }
                }
                // If all the positions are filled,
                // then decrement the count of every
                // element by 1
                if (l == k - 1) {
                    for (l = 0; l < k - 1; l++) {
                        elements[l].count -= 1;
                    }
                }
            }
        }
        // Check in elements for items which have count
        // more than n/k
        for (int i = 0; i < k - 1; i++) {
            // Actual count of elements
            int actualCount = 0;
            for (int num : nums) {
                if (num == elements[i].value) {
                    actualCount++;
                }
            }
            if (actualCount > n / k) {
                result.add(elements[i].value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 8, 4, 4};
        int k = 3;
        System.out.println(findElements(nums, k));

        nums = new int[]{4, 2, 2, 7};
        k = 3;
        System.out.println(findElements(nums, k));

        nums = new int[]{2, 7, 2};
        k = 2;
        System.out.println(findElements(nums, k));

        nums = new int[]{2, 3, 3, 2};
        k = 3;
        System.out.println(findElements(nums, k));
    }

    /**
     * This class will store the every element
     * and its count in the array
     */
    static class Element {
        private int value;
        private int count;
    }
}
