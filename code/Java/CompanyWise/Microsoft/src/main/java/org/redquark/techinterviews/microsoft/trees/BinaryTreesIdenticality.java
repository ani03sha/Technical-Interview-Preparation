package org.redquark.techinterviews.microsoft.trees;

/**
 * Given two binary trees, the task is to find if both of them are identical or
 * not.
 * 
 * @author Anirudh Sharma
 *
 */
public class BinaryTreesIdenticality {

	// Root of the first tree
	private static Node root1;

	// Root of the second tree
	private static Node root2;

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
	 * This method checks if two binary trees are equal or not
	 */
	private static boolean checkIfTreesAreEqual(Node rootA, Node rootB) {

		// Base condition - If both roots are null
		if (rootA == null && rootB == null) {
			return true;
		}

		// If both trees are non empty, we will compare them
		if (rootA != null && rootB != null) {
			return (rootA.data == rootB.data && checkIfTreesAreEqual(rootA.left, rootB.left)
					&& checkIfTreesAreEqual(rootA.right, rootB.right));
		}

		return false;
	}

	public static void main(String[] args) {

		root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);

		root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);

		System.out.println(checkIfTreesAreEqual(root1, root2) ? "Trees are identical" : "Trees are not identical");
	}

}
