package org.redquark.techinterviews.microsoft.trees;

/**
 * Given a Binary Tree and a number k. Print all nodes that are at distance k
 * from root (root is considered at distance 0 from itself). Nodes should be
 * printed from left to right. If k is more that height of tree, nothing should
 * be printed.
 * 
 * @author Anirudh Sharma
 *
 */
public class KDistanceFromRoot {

	// Root of the BST
	private static Node root;

	/**
	 * This class represents each node in the BST
	 */
	private static class Node {

		// Data to be stored in each node of the BST
		private int data;
		// Left child of BST
		private Node left;
		// Right child of BST
		private Node right;

		/**
		 * This constructor creates each node in the BST
		 */
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * This method prints all the nodes that are at K distance from the root
	 */
	private static void printKDistant(Node node, int k) {

		// Base condition - if root is null then there is no tree
		if (node == null) {
			return;
		}

		// If the k = 0, the return root
		if (k == 0) {
			System.out.print(node.data + " ");
			return;
		} else {
			// Go left recursively
			printKDistant(node.left, k - 1);
			// Go right recursively
			printKDistant(node.right, k - 1);

		}

	}

	public static void main(String[] args) {

		// Creating the tree
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);

		printKDistant(root, 2);
	}

}
