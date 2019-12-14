package org.redquark.techinterviews.adobe;

/**
 * This class uses merge sort to sort a linked list
 * 
 * @author Anirudh Sharma
 *
 */
public class Adobe003_LinkedListMergeSort {

	// Head node of the linked list
	private static Node head;

	private static Node sort(Node node) {

		// Base case - if head is null which means there is no linked list
		if (node == null || node.next == null) {
			return node;
		}

		// Get the middle of the linked list
		Node middle = getMiddle(node);
		// Get the next node of the middle of the linked list
		Node nextOfMiddle = middle.next;

		// Set the next of middle to null - this is done to divide the linked list in
		// two halves
		middle.next = null;

		// Apply merge sort on left half - head to middle
		Node left = sort(node);
		// Apply merge sort on the right half - nextOfMiddle to the end
		Node right = sort(nextOfMiddle);

		// Merge the left and right halves
		Node n = merge(left, right);

		return n;

	}

	private static Node merge(Node left, Node right) {

		// This node will store the reference of the merged result
		Node result = null;
		// Base cases
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		// Merge recursively
		if (left.data <= right.data) {
			result = left;
			result.next = merge(left.next, right);
		} else {
			result = right;
			result.next = merge(left, right.next);
		}

		return result;
	}

	/**
	 * This method returns the middle of the linked list
	 */
	private static Node getMiddle(Node node) {

		// Base condition - if the node is null
		if (node == null) {
			return node;
		}

		// Create fast and slow pointers
		Node slow = node;
		Node fast = node;

		// Loop until the fast pointer reach the end of the linked list
		while (fast.next != null && fast.next.next != null) {
			// Move slow pointer one step ahead
			slow = slow.next;
			// Move fast pointer two steps ahead
			fast = fast.next.next;
		}
		return slow;
	}

	/**
	 * This method add a new node with the given data as the front of the linked
	 * list
	 */
	private static void add(int data) {
		// Create a new node with the given data
		Node n = new Node(data);
		// Reference the next of this node to the head of the current linked list
		n.next = head;
		// Assign the newly created node as the head of the linked list
		head = n;
	}

	/**
	 * This method prints the linked list
	 */
	private static void print(Node n) {
		// Get the reference of the head
		Node node = n;
		// Loop until the end of the linked list
		while (node != null) {
			System.out.print(node.data + " ");
			// Move pointer one step ahead
			node = node.next;
		}

	}

	/**
	 * This class represents each node of the linked list
	 */
	private static class Node {

		// Data to be stored in each node of the linked list
		private int data;
		// Next pointer of the current node
		private Node next;

		/**
		 * Default constructor - this creates each node of the linked list
		 */
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		// Create a new linked list
		for (int i = 1; i <= 10; i++) {
			add(i);
		}

		System.out.print("Linked list before sorting: ");
		print(head);

		// Sorting the list
		head = sort(head);

		System.out.print("\nLinked list after sorting: ");
		print(head);
	}
}
