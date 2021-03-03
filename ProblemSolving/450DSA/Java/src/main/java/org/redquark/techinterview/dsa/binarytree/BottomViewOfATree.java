package org.redquark.techinterview.dsa.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree, print the bottom view from left to right.
 * A node is included in bottom view if it can be seen when we look at the tree from bottom.
 * <p>
 * Constraints:
 * 1 <= Number of nodes <= 10^5
 * 1 <= Data of a node <= 10^5
 */
public class BottomViewOfATree {

    private static List<Integer> bottomView(Node root) {
        // List to store the result
        List<Integer> result = new ArrayList<>();
        // Special case
        if (root == null) {
            return result;
        }
        // Horizontal distance for a node.
        // It will be zero for the root node.
        int horizontalDistance = 0;
        // TreeMap to store the keys in sorted order.
        Map<Integer, Integer> treeMap = new TreeMap<>();
        // Queue for level order traversal.
        Queue<Node> nodes = new LinkedList<>();
        // Initialize the values
        root.horizontalDistance = horizontalDistance;
        nodes.add(root);
        // Loop until the queue is empty.
        while (!nodes.isEmpty()) {
            // Get the node from the head
            Node current = nodes.remove();
            // Get the current horizontal distance
            horizontalDistance = current.horizontalDistance;
            // Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node
            // having same horizontal distance we need to replace
            // the data in the map.
            treeMap.put(horizontalDistance, current.data);
            // Check for left and right children
            if (current.left != null) {
                current.left.horizontalDistance = horizontalDistance - 1;
                nodes.add(current.left);
            }
            if (current.right != null) {
                current.right.horizontalDistance = horizontalDistance + 1;
                nodes.add(current.right);
            }
        }
        // Populate the result list
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println(bottomView(root));
    }

    static class Node {
        final int data;
        int horizontalDistance;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            horizontalDistance = Integer.MAX_VALUE;
        }
    }
}
