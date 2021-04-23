package org.redquark.techinterview.ctci.treesandgraphs;

/**
 * @author Anirudh Sharma
 * <p>
 * Write an algorithm to find the "next" node (i .e., in-order successor) of a given node in a
 * binary tree.
 * <p>
 * You may assume that each node has a link to its parent.
 */
public class Successor {

    private static TreeNode getSuccessor(TreeNode node) {
        // Base case
        if (node == null) {
            return null;
        }
        // CASE 1:
        // Check if node has right child, if so, return left
        // most node in its right subtree
        if (node.right != null) {
            // Move to the right child
            node = node.right;
            // Now find the left most child of the tree rooted
            // at node
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        // CASE 2:
        // If the right child is null, then we will find the
        // first ancestor of the node for which the node in
        // the left subtree
        while (true) {
            // Get the parent of the node
            TreeNode parent = node.parent;
            // Check if parent is null
            if (parent == null) {
                break;
            }
            // If the specified node is in left subtree
            if (parent.left == node) {
                return parent;
            } else {
                // Move to the grandparent
                node = parent;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.parent = root;
        root.right = new TreeNode(3);
        root.right.parent = root;
        root.left.left = new TreeNode(4);
        root.left.left.parent = root.left;
        root.left.right = new TreeNode(5);
        root.left.right.parent = root.left;
        root.right.right = new TreeNode(6);
        root.right.right.parent = root.right;

        TreeNode successor = getSuccessor(root.right);
        System.out.println(successor == null ? "NULL" : successor.data);

        successor = getSuccessor(root.left.left);
        System.out.println(successor == null ? "NULL" : successor.data);

        successor = getSuccessor(root.right.right);
        System.out.println(successor == null ? "NULL" : successor.data);
    }
}
