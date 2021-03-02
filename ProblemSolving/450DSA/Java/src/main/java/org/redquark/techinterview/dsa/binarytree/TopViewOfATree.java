package org.redquark.techinterview.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a pointer to the root of a binary tree, print the top view of the binary tree.
 * <p>
 * The tree as seen from the top the nodes, is called the top view of the tree.
 * <p>
 * Constraints:
 * 1 <= N <= 10^5
 * 1 <= Node Data <= 10^5
 */
public class TopViewOfATree {

    private static List<Integer> topView(Node root) {
        // List to store the top view
        List<Integer> result = new ArrayList<>();
        // TreeMap to store node's data, height and
        // horizontal distance
        Map<Integer, Pair> treeMap = new TreeMap<>();
        topView(root, 0, 0, treeMap);
        for (Map.Entry<Integer, Pair> entry : treeMap.entrySet()) {
            result.add(entry.getValue().nodeData);
        }
        return result;
    }

    private static void topView(Node root, int verticalDistance, int horizontalDistance, Map<Integer, Pair> treeMap) {
        // Base case
        if (root == null) {
            return;
        }
        // If the node for a horizontal distance is not
        // present in the map, add it.
        if (!treeMap.containsKey(horizontalDistance)) {
            treeMap.put(horizontalDistance, new Pair(root.data, verticalDistance));
        }
        // If the node for a horizontal distance is present,
        // then we will pick up the node that comes first
        else {
            Pair currentPair = treeMap.get(horizontalDistance);
            if (currentPair.height >= verticalDistance) {
                treeMap.put(horizontalDistance, new Pair(root.data, verticalDistance));
            }
        }
        topView(root.left, verticalDistance + 1, horizontalDistance - 1, treeMap);
        topView(root.right, verticalDistance + 1, horizontalDistance + 1, treeMap);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(topView(root));

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println(topView(root));
    }

    static class Pair {
        int nodeData;
        int height;

        Pair(int nodeData, int height) {
            this.nodeData = nodeData;
            this.height = height;
        }
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
