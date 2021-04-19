package org.redquark.techinterview.ctci.treesandgraphs;

import static org.redquark.techinterview.ctci.treesandgraphs.TreeNode.inorder;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a
 * binary search tree with minimal height.
 */
public class MinimalTree {

    private static TreeNode createMinimalTree(int[] a) {
        return createMinimalTree(a, 0, a.length - 1);
    }

    private static TreeNode createMinimalTree(int[] a, int start, int end) {
        // Base case
        if (end < start) {
            return null;
        }
        // Get the middle element of the array
        int middle = start + (end - start) / 2;
        // Create a new node with the data at the
        // middle index
        TreeNode node = new TreeNode(a[middle]);
        // Left and right children
        node.left = createMinimalTree(a, start, middle - 1);
        node.right = createMinimalTree(a, middle + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = createMinimalTree(a);
        inorder(root);
    }
}
