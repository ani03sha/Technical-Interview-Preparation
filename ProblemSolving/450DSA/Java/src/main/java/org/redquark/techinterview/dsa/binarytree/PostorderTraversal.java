package org.redquark.techinterview.dsa.binarytree;

import java.util.Stack;

/**
 * @author Anirudh Sharma
 * * <p>
 * * Given a binary tree, write an iterative and recursive solution to traverse the tree using postorder traversal.
 */
public class PostorderTraversal {

    private static void postorderTraversalRecursively(Node root) {
        if (root == null) {
            return;
        }
        postorderTraversalRecursively(root.left);
        postorderTraversalRecursively(root.right);
        System.out.print(root.data + " ");
    }

    private static void postorderTraversalIteratively(Node root) {
        if (root == null) {
            return;
        }
        // Stack to store the nodes of the tree
        Stack<Node> nodes = new Stack<>();
        // Push the root to the stack
        nodes.push(root);
        // Another stack to store postorder traversal
        Stack<Integer> postOrder = new Stack<>();
        // Loop until the stack is empty
        while (!nodes.isEmpty()) {
            // Get the current node from the stack
            Node current = nodes.pop();
            postOrder.push(current.data);
            // Push left child if not null
            if (current.left != null) {
                nodes.add(current.left);
            }
            // Push right child if not null
            if (current.right != null) {
                nodes.add(current.right);
            }
        }
        while (!postOrder.isEmpty()) {
            System.out.print(postOrder.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        System.out.println("Recursive:");
        postorderTraversalRecursively(root);
        System.out.println("\nIterative:");
        postorderTraversalIteratively(root);
        System.out.println("\n");

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println("Recursive:");
        postorderTraversalRecursively(root);
        System.out.println("\nIterative:");
        postorderTraversalIteratively(root);
        System.out.println("\n");


        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Recursive:");
        postorderTraversalRecursively(root);
        System.out.println("\nIterative:");
        postorderTraversalIteratively(root);
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
