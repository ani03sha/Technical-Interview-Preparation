package org.redquark.techinterview.dsa.binarytree;

import java.util.Stack;

/**
 * @author Anirudh Sharma
 * * <p>
 * * Given a binary tree, write an iterative and recursive solution to traverse the tree using preorder traversal.
 */
public class PreorderTraversal {

    private static void preorderTraversalRecursively(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversalRecursively(root.left);
        preorderTraversalRecursively(root.right);
    }

    private static void preorderTraversalIteratively(Node root) {
        if (root == null) {
            return;
        }
        // Stack to store the nodes of the tree
        Stack<Node> nodes = new Stack<>();
        // Push the root to the stack
        nodes.push(root);
        // Loop until the stack is empty
        while (!nodes.isEmpty()) {
            // Get the current node from the stack
            Node current = nodes.pop();
            System.out.print(current.data + " ");
            // Push right child if not null
            if (current.right != null) {
                nodes.push(current.right);
            }
            // Push left child if not null
            if (current.left != null) {
                nodes.push(current.left);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        System.out.println("Recursive:");
        preorderTraversalRecursively(root);
        System.out.println("\nIterative:");
        preorderTraversalIteratively(root);
        System.out.println("\n");

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println("Recursive:");
        preorderTraversalRecursively(root);
        System.out.println("\nIterative:");
        preorderTraversalIteratively(root);
        System.out.println("\n");


        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Recursive:");
        preorderTraversalRecursively(root);
        System.out.println("\nIterative:");
        preorderTraversalIteratively(root);
        System.out.println("\n");
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
