package org.redquark.techinterview.dsa.binarytree;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree, the task is to create a new binary tree which is a mirror image of
 * the given binary tree.
 */
public class MirrorOfATree {

    private static Node mirror(Node root) {
        // Base case
        if (root == null) {
            return null;
        }
        // Get left and right children of the node
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        // Swap the nodes
        root.right = left;
        root.left = right;
        return root;
    }

    private static void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        inorderTraversal(mirror(root));
        System.out.println();

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        inorderTraversal(mirror(root));
        System.out.println();

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inorderTraversal(mirror(root));
        System.out.println();
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
