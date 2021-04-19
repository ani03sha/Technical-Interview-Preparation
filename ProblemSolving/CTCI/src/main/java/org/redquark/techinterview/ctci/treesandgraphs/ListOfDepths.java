package org.redquark.techinterview.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g.,
 * if you have a tree with depth D, you'll have D linked lists).
 */
public class ListOfDepths {

    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        // Resultant list
        List<List<Integer>> result = new ArrayList<>();
        // Special case
        if (root == null) {
            return result;
        }
        // Queue to store nodes
        Queue<TreeNode> nodes = new LinkedList<>();
        // Process root node
        nodes.add(root);
        // Loop until the queue is empty
        while (!nodes.isEmpty()) {
            // Get the size of the queue. This represents the
            // number of nodes at a given level
            int size = nodes.size();
            // Loop for every node at the given level
            List<Integer> currentLevelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // Current node
                TreeNode currentNode = nodes.poll();
                // Add this node to the list
                if (currentNode != null) {
                    currentLevelNodes.add(currentNode.data);
                    // Check for left and right children
                    if (currentNode.left != null) {
                        nodes.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        nodes.add(currentNode.right);
                    }
                }
            }
            // Add current level nodes to final result
            result.add(currentLevelNodes);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrderTraversal(root));
    }
}
