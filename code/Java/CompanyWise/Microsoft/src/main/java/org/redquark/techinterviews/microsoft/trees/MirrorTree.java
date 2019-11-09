package org.redquark.techinterviews.microsoft.trees;

/**
 * @author Anirudh Sharma
 *
 */
public class MirrorTree {

	// Root node of the three
	private static Node root;

	/**
	 * This class represents each node in a binary tree
	 */
	private static class Node {

		// Data to be stored in the node of the three
		private int data;
		// Left child of the node
		private Node left;
		// Right child of the node
		private Node right;

		/**
		 * This constructor will create a node in a tree with null left an right
		 * children
		 */
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * This method traverses the tree in "inorder" fashion
	 */
	private static void inorder() {
		inorder(root);
	}

	/**
	 * This method traverses the tree in "inorder" fashion
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
	 * This method return the head of the mirror of the tree
	 */
	private static void mirror() {
		root = mirror(root);
	}

	/**
	 * This method return the head of the mirror of the tree
	 */
	private static Node mirror(Node node) {
		// Base condition - when the root is null it means there is no tree
		if (node == null) {
			return null;
		}

		// Get the left and right subtrees
		Node left = mirror(node.left);
		Node right = mirror(node.right);

		// Swap the left and right pointers
		node.left = right;
		node.right = left;

		return node;
	}

	public static void main(String[] args) {

		// Creating the tree
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Original tree in inorder");
		inorder();

		// Mirror the tree
		mirror();

		System.out.println("\nMirror tree in inorder");
		inorder();
	}

}
