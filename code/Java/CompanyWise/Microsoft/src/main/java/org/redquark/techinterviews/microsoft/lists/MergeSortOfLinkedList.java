package org.redquark.techinterviews.microsoft.lists;

/**
 * @author Anirudh Sharma
 *
 */
public class MergeSortOfLinkedList {

	// Head of the linked list
	private static Node head;

	/**
	 * This inner static class represents each node of the linked list
	 */
	private static class Node {

		// Data to be stored in the node of the linked list
		private int data;
		// Next pointer of the node
		private Node next;

		// Constructor that will be used to create an instance of a node with the given
		// data
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * This method adds a new node at the front of the existing linked list
	 */
	private static void add(int data) {
		// Creating the instance of a new node with the given data
		Node newNode = new Node(data);
		// Make the next of this node point to the current head
		newNode.next = head;
		// Make the new node as the new head
		head = newNode;
	}

	/**
	 * This method prints the nodes in the linked list
	 */
	private static void print(Node head) {
		// Taking the reference of the head
		Node node = head;
		// Loop through each node one by one until we reach to the end of the list
		while (node != null) {
			// Print the node data
			System.out.print(node.data + " ");
			// Move the pointer one node ahead
			node = node.next;
		}
	}

	private static Node mergeSort(Node node) {

		// Base case - if head is null or linked list has only one node
		if (node == null || node.next == null) {
			return node;
		}

		// Get the middle of the list
		Node middle = getMiddle(node);

		// Apply merge sort on the left list
		Node left = mergeSort(node);
		// Apply merge sort on the right list
		Node right = mergeSort(middle);

		// Merge the left and right sublists
		Node sorted = sortedMerge(left, right);

		return sorted;
	}

	/**
	 * Utility method to get the middle of the linked list
	 */
	private static Node getMiddle(Node node) {

		// Base case - if the head is null
		if (head == null) {
			return head;
		}

		// Slow and fast pointers
		Node slow = node;
		Node fast = node;

		// Loop through the list
		while (fast.next != null && fast.next.next != null) {
			// Slow node will move one node ahead at a time
			slow = slow.next;
			// Fast node will move two nodes ahead at a time
			fast = fast.next.next;
		}

		// Get the reference of next node of the slow pointer
		Node temp = slow.next;
		// Make the next of slow to null
		slow.next = null;
		// Return the next of middle element of the passed linked list
		return temp;
	}

	private static Node sortedMerge(Node a, Node b) {

		// Declare the result node
		Node result = null;

		// Base cases
		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		// Pick either a or b an recur
		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}

		return result;
	}

	public static void main(String[] args) {

		// Creating some nodes for the list
		for (int i = 1; i <= 8; i++) {
			add(i);
		}

		// Original list
		System.out.println("Original list:");
		print(head);

		// Sort the list using merger sort
		head = mergeSort(head);

		// Sorted list
		System.out.println("\nSorted list:");
		print(head);
	}

}
