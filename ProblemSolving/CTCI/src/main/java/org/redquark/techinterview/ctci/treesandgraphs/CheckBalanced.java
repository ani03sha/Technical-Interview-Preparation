package org.redquark.techinterview.ctci.treesandgraphs;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree
 * is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class CheckBalanced {

    private static boolean isBalanced(TreeNode root) {
        // Base condition
        if (root == null) {
            return true;
        }
        // Check the difference between the heights of the
        // left and right subtrees
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        // Recurse for left and right subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode node) {
        // Base case
        if (node == null) {
            return 0;
        }
        // Get the height of the the subtree rooted at node
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
