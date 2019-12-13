package org.redquark.techinterviews.adobe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree, convert it into its mirror.
 * 
 * @author Anirudh Sharma
 *
 */
public class Adobe001_MirrorTree {

	// Root of the Binary Search Tree
	private static Node root;

	/**
	 * This method converts a Binary Tree into its mirror recursively
	 */
	private static void mirrorRecursively() {
		root = mirrorRecursively(root);
	}

	/**
	 * This method recursively returns the root of the mirrored tree
	 */
	private static Node mirrorRecursively(Node node) {

		// Base condition - if the root is null it means there is no tree
		if (node == null) {
			return null;
		}

		// Get the references of the roots of left and right subtrees of the current
		// node
		Node left = mirrorRecursively(node.left);
		Node right = mirrorRecursively(node.right);

		// Swap the left and right child references
		node.left = right;
		node.right = left;

		return node;
	}

	private static void mirrorIteratively() {
		mirrorIteratively(root);
	}

	private static void mirrorIteratively(Node node) {

		// Base condition - if the root is null. It means there is not tree
		if (node == null) {
			return;
		}

		// Creating an instance of the Queue
		Queue<Node> queue = new LinkedList<>();
		// Add root to the queue
		queue.add(node);

		// Perform BFS and keep swapping left and right children
		while (queue.size() > 0) {
			// Pop top from the queue
			Node current = queue.poll();

			// Swap and left and right child
			Node temp = current.left;
			current.left = current.right;
			current.right = temp;

			// Push left and right children
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
	}

	/**
	 * This method prints the nodes of the tree in inorder
	 */
	private static void inorder() {
		inorder(root);
	}

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
		inorder();

		// Mirror the tree recursively
		mirrorRecursively();

		System.out.print("\nTree after mirroring (recursively): ");
		inorder();

		// Mirror the tree iteratively
		mirrorIteratively();

		System.out.print("\nTree after mirroring (iteratively): ");
		inorder();
	}
}
