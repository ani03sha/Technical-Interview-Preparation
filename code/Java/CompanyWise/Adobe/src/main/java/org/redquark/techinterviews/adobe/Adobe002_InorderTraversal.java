package org.redquark.techinterviews.adobe;

/**
 * Inorder traversal => Left -> Root -> Right
 * 
 * @author Anirudh Sharma
 *
 */
public class Adobe002_InorderTraversal {

	// Root of the Binary Search Tree
	private static Node root;

	/**
	 * Overloaded method - This method prints the nodes of the tree in inorder
	 */
	private static void inorder(Node node) {
		// Base case - where the root is null. This means there is no tree
		if (node == null) {
			return;
		}

		// Calling the left subtree
		inorder(node.left);
		// Printing the parent node
		System.out.print(node.data + " ");
		// Calling the right subtree
		inorder(node.right);
	}

	/**
	 * This class represents each node of the Binary Search Tree
	 */
	private static class Node {

		// Data to be stored in each node of the tree
		private int data;
		// Left child of this node
		private Node left;
		// Right child of
		private Node right;

		/**
		 * Default constructor which creates new instance of the node with null left and
		 * right children
		 */
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {

		// Creating some nodes of the tree
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.print("Original tree: ");
		inorder(root);

	}
}
