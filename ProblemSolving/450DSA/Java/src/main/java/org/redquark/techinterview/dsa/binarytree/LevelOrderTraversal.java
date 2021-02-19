package org.redquark.techinterview.dsa.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree, find its level order traversal.
 * Level order traversal of a tree is breadth-first traversal for the tree.
 * <p>
 * Constraints:
 * 1 <= Number of nodes<= 10^4
 * 1 <= Data of a node <= 10^4
 */
public class LevelOrderTraversal {

    private static List<Integer> levelOrderTraversal(Node root) {
        // Special case
        if (root == null) {
            return null;
        }
        // List to store the level order traversal
        List<Integer> result = new ArrayList<>();
        // Queue to store the nodes of the tree
        Queue<Node> nodes = new LinkedList<>();
        // Add root to the queue
        nodes.add(root);
        // Loop until the queue is empty
        while (!nodes.isEmpty()) {
            // Get the current node
            Node current = nodes.poll();
            // Add current node to the result
            result.add(current.data);
            // Add left and right children
            if (current.left != null) {
                nodes.add(current.left);
            }
            if (current.right != null) {
                nodes.add(current.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        System.out.println(levelOrderTraversal(root));

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(levelOrderTraversal(root));
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
