package org.redquark.techinterviews.microsoft.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array arr[] and a number K where K is smaller than size of array,
 * the task is to find the K`th smallest element in the given array. It is given
 * that all array elements are distinct.
 * 
 * @author Anirudh Sharma
 *
 */
public class KthSmallestElement {

	public static void main(String[] args) {

		// Array in which K`th smallest element needs to be searched
		Integer a[] = { 12, 3, 5, 7, 19 };
		// Value of K
		int k = 2;

		System.out.print("K'th smallest element is " + findKthSmallestElement(a, k));
	}

	/**
	 * This method returns the K`th smallest element in an array
	 */
	private static int findKthSmallestElement(Integer[] a, int k) {

		// Convert array into list
		List<Integer> A = new ArrayList<>(Arrays.asList(a));

		// Create an empty min-heap and initialize it with all input elements
		Queue<Integer> heap = new PriorityQueue<>(A);

		// Pop from the heap k-1 times
		while (--k > 0) {
			heap.poll();
		}

		// Return the root of the min heap
		return heap.peek();
	}
}
