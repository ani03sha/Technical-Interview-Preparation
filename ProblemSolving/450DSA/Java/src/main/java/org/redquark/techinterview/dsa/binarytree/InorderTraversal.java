package org.redquark.techinterview.dsa.binarytree;

import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree, write an iterative and recursive solution to traverse the tree using inorder traversal.
 */
public class InorderTraversal {

    private static void inorderTraversalRecursively(Node root) {
        // Base case
        if (root == null) {
            return;
        }
        inorderTraversalRecursively(root.left);
        System.out.print(root.data + " ");
        inorderTraversalRecursively(root.right);
    }

    private static void inorderTraversalIteratively(Node root) {
        // Stack to store the nodes of the tree
        Stack<Node> nodes = new Stack<>();
        // Take reference to the root in a temp node
        Node temp = root;
        // If the temp node is null and stack is
        // empty, then we are done
        while (!nodes.isEmpty() || temp != null) {
            // If the temp node exists, push it into
            // the stack and move to left child
            if (temp != null) {
                nodes.push(temp);
                temp = temp.left;
            }
            // If the temp node doesn't exist, pop from
            // the stack and print the node and move to
            // the right child
            else {
                temp = nodes.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        System.out.println("Recursive:");
        inorderTraversalRecursively(root);
        System.out.println("\nIterative:");
        inorderTraversalIteratively(root);
        System.out.println("\n");

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println("Recursive:");
        inorderTraversalRecursively(root);
        System.out.println("\nIterative:");
        inorderTraversalIteratively(root);
        System.out.println("\n");


        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Recursive:");
        inorderTraversalRecursively(root);
        System.out.println("\nIterative:");
        inorderTraversalIteratively(root);
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
