package org.redquark.techinterviews.adobe;

/**
 * @author Anirudh Sharma
 *
 */
public class Adobe005_ReverseDoublyLinkedList {

	// Head of the doubly linked list
	private static Node head;

	/**
	 * This method reverses the doubly linked list
	 */
	private static void reverse(Node node) {
		// Get the reference of the current node
		Node current = node;
		// Temp node
		Node temp = null;

		// Loop through all the nodes in the doubly linked list and swap next and
		// previous pointers
		while (current != null) {
			// Swapping
			temp = current.previous;
			current.previous = current.next;
			current.next = temp;
			// Move one step backwards (from tail to head)
			current = current.previous;
		}

		// Updating for the head node of the doubly linked list
		if (temp != null) {
			head = temp.previous;
		}
	}

	/**
	 * This method adds a new node at the beginning of the existing doubly linked
	 * list
	 */
	private static void add(int data) {
		// Create an instance of new node with the given data
		Node node = new Node(data);
		// Add the newly created node at the beginning of the doubly linked list, hence
		// the previous of current head will point to this node and the next of this
		// node will point to the current head
		node.next = head;
		node.previous = null;

		// Change the previous of the head node to the new node
		if (head != null) {
			head.previous = node;
		}

		// Update the head - make the new node as the new head
		head = node;
	}

	/**
	 * This method prints the data present in the linked list
	 */
	private static void print(Node node) {
		// Get the reference of the current node
		Node current = node;
		// Loop through the linked list in the forward direction
		while (current != null) {
			// Print the data of the node
			System.out.print(current.data + " ");
			// Move the node one step ahead
			current = current.next;
		}
	}

	/**
	 * This class represents each node in the doubly linked list
	 */
	private static class Node {

		// Data to be stored in the node
		private int data;
		// Previous pointer of the node
		private Node previous;
		// Next pointer of the node
		private Node next;

		/**
		 * Default constructor that will create a node in the doubly linked list
		 */
		Node(int data) {
			this.data = data;
			this.previous = null;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		// Add some data in the doubly linked list
		for (int i = 1; i <= 10; i++) {
			add(i);
		}

		System.out.print("Original doubly linked list: ");
		print(head);

		// Reverse the doubly linked list
		reverse(head);

		System.out.print("\nReversed doubly linked list: ");
		print(head);
	}
}
