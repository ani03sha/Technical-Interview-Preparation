package org.redquark.techinterview.ctci.treesandgraphs.additional;

import org.redquark.techinterview.ctci.treesandgraphs.TreeNode;

/**
 * @author Anirudh Sharma
 * <p>
 * Find inorder successor of a given node in a BST
 */
public class SuccessorBST {

    private static TreeNode getSuccessor(TreeNode root, TreeNode node) {
        // Base case
        if (root == null) {
            return null;
        }
        // Reference of the root
        TreeNode current = root;
        // Successor node (which will be the output)
        TreeNode successor = null;
        // Loop until we reach the specified node
        while (current.data != node.data) {
            // If current node's data is greater than the
            // specified node's data, move left
            if (current.data > node.data) {
                successor = current;
                current = current.left;
            }
            // Else continue searching in right subtree
            else {
                current = current.right;
            }
        }
        // Check if the the specified node has a right subtree.
        // 1. If it has, then return leftmost child in the left subtree
        // 2. If not, return successor which has last left turn node
        if (current.right != null) {
            successor = findMinimum(current.right);
        }
        return successor;
    }

    private static TreeNode findMinimum(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        TreeNode successor = getSuccessor(root, root.right.right);
        System.out.println(successor == null ? "NULL" : successor.data);

        successor = getSuccessor(root, root.left.right);
        System.out.println(successor == null ? "NULL" : successor.data);
    }
}
