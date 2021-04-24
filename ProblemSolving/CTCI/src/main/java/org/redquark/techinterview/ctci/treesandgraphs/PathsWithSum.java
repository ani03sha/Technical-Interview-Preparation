package org.redquark.techinterview.ctci.treesandgraphs;

import java.util.HashMap;

/**
 * @author Anirudh Sharma (
 * <p>
 * You are given a binary tree in which each node contains an integer value (which might be positive or negative).
 * <p>
 * Design an algorithm to count the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 */
public class PathsWithSum {

    private static int pathSum(TreeNode root, int target) {
        return countPathSum(root, target, 0, new HashMap<>());
    }

    private static int countPathSum(TreeNode root, int target, int cumulativeSum, HashMap<Integer, Integer> pathCount) {
        // Check for the node
        if (root == null) {
            return 0;
        }
        // Update the current sum
        cumulativeSum += root.data;
        // Search the difference of cumulative sum and target and
        // search in the hash map
        int sum = cumulativeSum - target;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        // If cumulative sum is equal to the target,
        // we have found one valid path
        if (cumulativeSum == target) {
            totalPaths++;
        }
        // Update hash map
        updatePathCount(pathCount, cumulativeSum, 1);
        // Recurse for left and right
        totalPaths += countPathSum(root.left, target, cumulativeSum, pathCount);
        totalPaths += countPathSum(root.right, target, cumulativeSum, pathCount);
        // Decrement path count as this node is done
        updatePathCount(pathCount, cumulativeSum, -1);
        return totalPaths;
    }

    private static void updatePathCount(HashMap<Integer, Integer> pathCount, int cumulativeSum, int delta) {
        int count = pathCount.getOrDefault(cumulativeSum, 0) + delta;
        if (count == 0) {
            pathCount.remove(cumulativeSum);
        } else {
            pathCount.put(cumulativeSum, count);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(11);
        int target = 8;
        System.out.println(pathSum(root, target));
    }
}
