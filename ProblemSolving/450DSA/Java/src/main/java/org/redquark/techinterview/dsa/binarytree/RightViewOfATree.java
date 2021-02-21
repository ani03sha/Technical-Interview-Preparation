package org.redquark.techinterview.dsa.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a Binary Tree, find Right view of it.
 * Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.
 */
public class RightViewOfATree {

    private static List<Integer> rightView(Node root) {
        // List to the result
        List<Integer> result = new ArrayList<>();
        // Special case
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
            // Loop until the size
            for (int i = 0; i < size; i++) {
                // Get the current node
                Node current = nodes.poll();
                // If this is the last node of
                // the current level, add it to
                // the result
                if (current != null && i == size - 1) {
                    result.add(current.data);
                }
                // Move to the left child
                if (current != null && current.left != null) {
                    nodes.add(current.left);
                }
                // Move to the right child
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
        System.out.println(rightView(root));

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(rightView(root));


        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(rightView(root));
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
