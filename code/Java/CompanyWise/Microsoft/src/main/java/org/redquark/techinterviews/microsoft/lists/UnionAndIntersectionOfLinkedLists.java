package org.redquark.techinterviews.microsoft.lists;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class finds the union and intersection of the two linked lists
 * 
 * @author Anirudh Sharma
 *
 */
public class UnionAndIntersectionOfLinkedLists {

	// Head of the first linked list
	private static Node head1;

	// Head of the second linked list
	private static Node head2;

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
	 * This method unions the two linked list
	 */
	private static void union(Node node1, Node node2) {

		// Set to store nodes of lists. Since a Set can contain only unique elements so
		// we will be having the correct result
		Set<Integer> unionOfNodes = new LinkedHashSet<>();

		// Loop through the first list and add the nodes in the Set
		while (node1 != null) {
			unionOfNodes.add(node1.data);
			node1 = node1.next;
		}

		// Loop through the first list and add the nodes in the Set
		while (node2 != null) {
			unionOfNodes.add(node2.data);
			node2 = node2.next;
		}

		// Print all the nodes
		for (Integer i : unionOfNodes) {
			System.out.print(i + " ");
		}
	}

	/**
	 * This method finds the intersection of the two linked lists
	 */
	private static void intersection(Node node1, Node node2) {

		// Set to store nodes of linked lists
		Set<Integer> intersectionOfNodes = new LinkedHashSet<>();

		// Added all nodes of the first linked list to the Set
		while (node1 != null) {
			intersectionOfNodes.add(node1.data);
			node1 = node1.next;
		}

		// Loop through the second linked list and get only the common nodes
		while (node2 != null) {
			if (intersectionOfNodes.contains(node2.data)) {
				System.out.print(node2.data + " ");
			}
			node2 = node2.next;
		}
	}

	public static void main(String[] args) {

		head1 = new Node(1);
		head1.next = new Node(4);
		head1.next.next = new Node(9);
		head1.next.next.next = new Node(16);

		head2 = new Node(2);
		head2.next = new Node(4);
		head2.next.next = new Node(6);
		head2.next.next.next = new Node(8);
		head2.next.next.next.next = new Node(10);
		head2.next.next.next.next.next = new Node(12);
		head2.next.next.next.next.next.next = new Node(14);
		head2.next.next.next.next.next.next.next = new Node(16);

		System.out.print("Union of two linked lists: ");
		union(head1, head2);
		System.out.print("\nIntersection of two linked lists: ");
		intersection(head1, head2);
	}

}
