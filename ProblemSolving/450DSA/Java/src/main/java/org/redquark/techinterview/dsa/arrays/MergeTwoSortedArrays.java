package org.redquark.techinterview.dsa.arrays;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * <p>
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional
 * elements from nums2.
 */
public class MergeTwoSortedArrays {

    private static int[] merge(int[] nums1, int[] nums2) {
        // Variable to define the length of the final
        // sorted array
        int index = nums1.length - 1;
        // Length of the individual arrays
        int m = nums1.length - nums2.length;
        int n = nums2.length;
        // Decrement m and n by one to get the last index of
        // the respective arrays
        --m;
        --n;
        // Loop until there are elements in any one array
        while (m >= 0 && n >= 0) {
            // If nums1 has greater current element
            if (nums1[m] > nums2[n]) {
                nums1[index] = nums1[m];
                m--;
            } else {
                nums1[index] = nums2[n];
                n--;
            }
            index--;
        }
        // Check for nums2 in case some elements are left
        while (n >= 0) {
            nums1[index] = nums2[n];
            n--;
            index--;
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        System.out.println(Arrays.toString(merge(nums1, nums2)));

        nums1 = new int[]{1};
        nums2 = new int[]{};
        System.out.println(Arrays.toString(merge(nums1, nums2)));

        nums1 = new int[]{0, 0};
        nums2 = new int[]{1};
        System.out.println(Arrays.toString(merge(nums1, nums2)));

        nums1 = new int[]{1, 3, 5, 7, 0, 0, 0, 0, 0};
        nums2 = new int[]{0, 2, 6, 8, 9};
        System.out.println(Arrays.toString(merge(nums1, nums2)));
    }
}
