package org.redquark.techinterviews.microsoft.lists;

/**
 * @author Anirudh Sharma
 *
 */
public class DeleteANodeWithoutHeadPointer {

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

	/**
	 * This method deletes the node whose reference pointer is given
	 */
	private static void deleteNode(Node node) {
		// Take the reference of the next of the node to be deleted in a variable
		Node temp = node.next;
		// Copy the data of the next of the node to be deleted in the current node
		// reference. Therefore, it will actually override the data in the node to be
		// deleted.
		node.data = temp.data;
		// Now point the next of the next of the node to be deleted to the next of the
		// node to be deleted. That way we have the data of original node go away and we
		// can consider the node as deleted.
		node.next = temp.next;
	}

	public static void main(String[] args) {

		// Creating some nodes for the list
		for (int i = 8; i >= 1; i--) {
			add(i);
		}

		// Original list
		print(head);

		// Delete node with given reference
		deleteNode(head.next.next.next.next);
		System.out.println("\nModified linked list after deleting node: ");
		print(head);
	}
}
