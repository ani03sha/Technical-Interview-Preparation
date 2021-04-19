package org.redquark.techinterview.ctci.treesandgraphs;

/**
 * @author Anirudh Sharma
 * This class represents each node in a binary tree
 */
public class TreeNode {

    final int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
