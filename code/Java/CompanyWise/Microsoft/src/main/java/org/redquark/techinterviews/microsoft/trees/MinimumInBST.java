package org.redquark.techinterviews.microsoft.trees;

/**
 * This class finds the minimum element in a given BST
 * 
 * @author Anirudh Sharma
 *
 */
public class MinimumInBST {

	// Head of the BST
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
	 * This method adds nodes in a BST as per the properties of BST
	 */
	private static Node insert(int data, Node node) {

		// Base case - if the root is null then there is no tree and the new node to be
		// created would be the root
		if (node == null) {
			// Creating a new node with the given data
			return new Node(data);
		} else {
			// Recur down the tree
			if (data <= node.data) {
				node.left = insert(data, node.left);
			} else {
				node.right = insert(data, node.right);
			}
			// Return the node(unchanged) pointer
			return node;
		}
	}

	/**
	 * This tree returns the minimum node in the BST
	 */
	private static int minimumNode(Node node) {
		// Temp node
		Node temp = node;
		// Loop down to find the leftmost leaf
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.data;
	}

	public static void main(String[] args) {

		// Creating the tree
		root = insert(4, root);
		insert(2, root);
		insert(8, root);
		insert(3, root);
		insert(6, root);
		insert(5, root);

		System.out.println("Minimum value in BST is: " + minimumNode(root));
	}

}
