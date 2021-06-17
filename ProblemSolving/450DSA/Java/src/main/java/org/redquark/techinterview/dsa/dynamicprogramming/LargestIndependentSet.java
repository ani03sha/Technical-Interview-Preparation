package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a Binary Tree, find size of the Largest Independent Set(LIS) in it.
 * <p>
 * A subset of all tree nodes is an independent set if there is no edge between any
 * two nodes of the subset.
 */
public class LargestIndependentSet {

    private static int largestIndependentSet(TreeNode root) {
        // Special cases
        if (root == null) {
            return 0;
        }
        if (root.lis != 0) {
            return root.lis;
        }
        if (root.left == null && root.right == null) {
            return root.lis = 1;
        }
        // LIS if we exclude current node
        int exclude = largestIndependentSet(root.left) + largestIndependentSet(root.right);
        // LIS if we include current node
        int include = 1;
        if (root.left != null) {
            include += largestIndependentSet(root.left.left) + largestIndependentSet(root.left.right);
        }
        if (root.right != null) {
            include += largestIndependentSet(root.right.left) + largestIndependentSet(root.right.right);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
        System.out.println(largestIndependentSet(root));
    }

    static class TreeNode {
        final int data;
        int lis;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }
}
