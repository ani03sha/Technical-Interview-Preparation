package org.redquark.techinterview.dsa.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a Binary Tree, print Left view of it.
 * Left view of a Binary Tree is set of nodes visible when tree is visited from Left side.
 */
public class LeftViewOfATree {

    private static List<Integer> leftView(Node root) {
        // List to store the final result
        List<Integer> result = new ArrayList<>();
        // Base case
        if (root == null) {
            return result;
        }
        // Queue to store the nodes of the tree
        Queue<Node> nodes = new LinkedList<>();
        // Add root node to the queue
        nodes.add(root);
        // Loop until the queue is empty
        while (!nodes.isEmpty()) {
            // Get the size of the queue
            int size = nodes.size();
            // Loop through the size of the queue
            for (int i = 0; i < size; i++) {
                // Get the current node
                Node current = nodes.poll();
                // If this is the first node at the current level,
                // add it to the result list
                if (i == 0) {
                    result.add(current.data);
                }
                // Move to left child if exists
                if (current != null && current.left != null) {
                    nodes.add(current.left);
                }
                // Move to the right child if exists
                if (current != null && current.right != null) {
                    nodes.add(current.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        System.out.println(leftView(root));

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(leftView(root));


        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(leftView(root));
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
