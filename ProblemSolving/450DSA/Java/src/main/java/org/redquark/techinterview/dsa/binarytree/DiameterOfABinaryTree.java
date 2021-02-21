package org.redquark.techinterview.dsa.binarytree;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a Binary Tree, find diameter of it.
 * The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree.
 * <p>
 * Constraints:
 * 1 <= Number of nodes <= 10000
 * 1 <= Data of a node <= 1000
 */
public class DiameterOfABinaryTree {

    private static int diameter(Node root) {
        // Base case
        if (root == null) {
            return 0;
        }
        // Heights of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // Diameter of the left and right subtrees
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max((leftHeight + rightHeight + 1), Math.max(leftDiameter, rightDiameter));
    }

    private static int height(Node root) {
        // Base case
        if (root == null) {
            return 0;
        }
        // Height of left subtree
        int leftHeight = height(root.left);
        // Height of right subtree
        int rightHeight = height(root.right);
        // Return the maximum of leftHeight and rightHeight
        // plust 1 for the root
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        System.out.println(diameter(root));

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(diameter(root));

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(diameter(root));
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
