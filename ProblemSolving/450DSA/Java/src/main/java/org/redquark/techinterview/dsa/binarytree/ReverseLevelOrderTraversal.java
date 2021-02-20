package org.redquark.techinterview.dsa.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree of size N, find its reverse level order traversal i.e.,
 * the traversal must begin from the last level.
 * <p>
 * Constraints:
 * 1 ≤ N ≤ 10^4
 */
public class ReverseLevelOrderTraversal {

    private static List<Integer> reverseLevelOrderTraversal(Node root) {
        // List to store the final reverse level order traversal
        List<Integer> result = new ArrayList<>();
        // Special case
        if (root == null) {
            return result;
        }
        // Queue to store the nodes of the tree
        Queue<Node> nodes = new LinkedList<>();
        // Stack to store the nodes for reverse level order traversal
        Stack<Node> reverseLOT = new Stack<>();
        // Add root to the queue
        nodes.add(root);
        // Loop until the stack is empty
        while (!nodes.isEmpty()) {
            // Get the current node from the queue
            Node current = nodes.poll();
            // Push the current node to the stack
            reverseLOT.push(current);
            // Check if the right child exists
            if (current.right != null) {
                nodes.add(current.right);
            }
            // Check if the left child exists
            if (current.left != null) {
                nodes.add(current.left);
            }
        }
        // Pop all nodes from the stack and add them
        // to the result
        while (!reverseLOT.isEmpty()) {
            result.add(reverseLOT.pop().data);
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        System.out.println(reverseLevelOrderTraversal(root));

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(reverseLevelOrderTraversal(root));
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
