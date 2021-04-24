package org.redquark.techinterview.ctci.treesandgraphs;

/**
 * @author Anirudh Sharma
 * <p>
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2.
 * Create an algorithm to determine if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class CheckSubtree {

    private static boolean isSubtree(TreeNode t1, TreeNode t2) {
        // Base cases
        if (t2 == null) {
            // Since smaller tree is empty and every
            // empty tree is a subtree of any tree,
            // we will return true
            return true;
        }
        if (t1 == null) {
            // Bigger tree is empty, this means no tree
            // can be its subtree, return false
            return false;
        }
        // Further cases where we will match the nodes
        else if (t1.data == t2.data && matchTree(t1, t2)) {
            return true;
        }
        // Recurse and check for subtrees
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    private static boolean matchTree(TreeNode t1, TreeNode t2) {
        // Base case - if we have reached to the leaves
        if (t1 == null && t2 == null) {
            return true;
        }
        // One tree is empty, so they cannot match
        if (t1 == null || t2 == null) {
            return false;
        }
        // If the nodes don't match, return false
        else if (t1.data != t2.data) {
            return false;
        }
        // If we reach at this point, it means the roots
        // of both trees are matching.
        // Now we will recurse for the subtrees
        return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(2);
        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);
        System.out.println(isSubtree(t1, t2));

        t1.left.right.left = new TreeNode(0);
        System.out.println(isSubtree(t1, t2));
    }
}
