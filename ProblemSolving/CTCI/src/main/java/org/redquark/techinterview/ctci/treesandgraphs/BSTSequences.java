package org.redquark.techinterview.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Anirudh Sharma
 * <p>
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 * <p>
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 */
public class BSTSequences {

    private static ArrayList<LinkedList<Integer>> findBSTSequences(TreeNode root) {
        // List to store results
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
        // Base case
        if (root == null) {
            results.add(new LinkedList<>());
            return results;
        }
        // List to store the prefixes
        LinkedList<Integer> prefix = new LinkedList<>();
        // Since the first element of any sequence is the root
        // itself, add it to the list
        prefix.add(root.data);
        // Recursively traverse left and right subtrees
        ArrayList<LinkedList<Integer>> leftSequence = findBSTSequences(root.left);
        ArrayList<LinkedList<Integer>> rightSequence = findBSTSequences(root.right);
        // Weave both left and right lists
        for (LinkedList<Integer> left : leftSequence) {
            for (LinkedList<Integer> right : rightSequence) {
                // List to store weaved output
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                // Weave lists
                weaveLists(left, right, prefix, weaved);
                // Add all the elements of the weaved list into the
                // resultant list
                results.addAll(weaved);
            }
        }
        return results;
    }

    private static void weaveLists(LinkedList<Integer> left, LinkedList<Integer> right, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> weaved) {
        // Base case: if any of the list is empty, then we
        // have found one sequence in the form of prefixes
        // and the two lists
        if (left.isEmpty() || right.isEmpty()) {
            // Get the clone of prefix list and add the
            // two lists to it
            LinkedList<Integer> currentPrefix = new LinkedList<>(prefix);
            // Add elements from left and right lists
            currentPrefix.addAll(left);
            currentPrefix.addAll(right);
            // We have found out one valid subsequence, so add it to
            // the resultant list
            weaved.add(currentPrefix);
            return;
        }
        // If we are at this point, it means that we have not yet
        // found a valid subsequence.
        // In that case, we will recurse on both left and right lists
        // by removing one element from them.

        // Get the head of the left list
        Integer headLeft = left.removeFirst();
        // Add this to the prefix
        prefix.addLast(headLeft);
        // Weave list from this point
        weaveLists(left, right, prefix, weaved);
        // Remove the element from the prefix
        prefix.removeLast();
        // Again add the headLeft to the left list
        left.addFirst(headLeft);

        // Get the head of the right list
        Integer headRight = right.removeFirst();
        // Add this to the prefix
        prefix.addLast(headRight);
        // Weave list from this point
        weaveLists(left, right, prefix, weaved);
        // Remove the element from the prefix
        prefix.removeLast();
        // Again add the headLeft to the left list
        right.addFirst(headRight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(findBSTSequences(root));

        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(30);
        System.out.println(findBSTSequences(root));
    }
}
