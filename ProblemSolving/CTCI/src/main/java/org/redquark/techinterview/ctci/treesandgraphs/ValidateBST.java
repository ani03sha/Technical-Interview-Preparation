package org.redquark.techinterview.ctci.treesandgraphs;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class ValidateBST {

    private static boolean isBST(TreeNode root) {
        return isBST(root, null, null);
    }

    private static boolean isBST(TreeNode root, Integer min, Integer max) {
        // Check the base case
        if (root == null) {
            return true;
        }
        // Check if the BST property violates
        else if ((min != null && root.data <= min) || (max != null && root.data >= max)) {
            return false;
        }
        // Check for the subtree recursively
        else {
            return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(isBST(root));

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isBST(root));
    }
}
