package org.redquark.techinterview.dsa.binarytree;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree, find its height.
 * <p>
 * Constraints:
 * 1 <= Number of nodes <= 10^5
 * 1 <= Data of a node <= 10^5
 */
public class HeightOfABinaryTree {

    private static int getHeight(Node root) {
        // Special case
        if (root == null) {
            return 0;
        }
        // Get the height of the left subtree
        int leftHeight = getHeight(root.left);
        // Get the height of the right subtree
        int rightHeight = getHeight(root.right);
        // Return the max of left subtree height
        // and right subtree height plus 1 for root
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        System.out.println(getHeight(root));

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(getHeight(root));
    }

    static class Node {
        final int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
 