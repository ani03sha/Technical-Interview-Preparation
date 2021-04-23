package org.redquark.techinterview.ctci.treesandgraphs;

/**
 * @author Anirudh Sharma
 */
public class FirstCommonAncestor {

    private static TreeNode firstCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = firstCommonAncestor(root.left, p, q);
        TreeNode right = firstCommonAncestor(root.right, p, q);
        if ((left == p && right == q) || (left == q && right == p)) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(firstCommonAncestor(root, root.left, root.right).data);
        System.out.println(firstCommonAncestor(root, root.left, root.left.right.right).data);
    }
}
