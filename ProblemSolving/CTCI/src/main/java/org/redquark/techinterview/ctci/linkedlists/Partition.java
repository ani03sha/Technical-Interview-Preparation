package org.redquark.techinterview.ctci.linkedlists;

import static org.redquark.techinterview.ctci.linkedlists.Node.addNodeToLast;
import static org.redquark.techinterview.ctci.linkedlists.Node.print;

/**
 * @author Anirudh Sharma
 * <p>
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x.
 * <p>
 * If x is contained within the list, the values of x only need to be after the elements less than x.
 * <p>
 * The partition element x can appear anywhere in the "right partition"; it does not need to appear
 * between the left and right partitions.
 */
public class Partition {

    private static Node partition(Node head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        // Heads of both the partitions
        Node leftHead = null;
        Node rightHead = null;
        // Left partition and right partition
        Node leftTraversalNode = null;
        Node rightTraversalNode = null;
        // Reference to the head node
        Node traversalNode = head;
        // Loop through the linked list
        while (traversalNode != null) {
            // If the current node has data less than x
            if (traversalNode.data < x) {
                // This should run only one time for head
                if (leftHead == null) {
                    leftTraversalNode = traversalNode;
                    leftHead = leftTraversalNode;
                } else {
                    leftTraversalNode.next = traversalNode;
                    leftTraversalNode = traversalNode;
                }
            } else {
                if (rightHead == null) {
                    rightTraversalNode = traversalNode;
                    rightHead = rightTraversalNode;
                } else {
                    rightTraversalNode.next = traversalNode;
                    rightTraversalNode = traversalNode;
                }
            }
            traversalNode = traversalNode.next;
        }
        // Dereference nodes to avoid cycle
        if (leftTraversalNode != null) {
            leftTraversalNode.next = null;
        }
        if (rightTraversalNode != null) {
            rightTraversalNode.next = null;
        }
        if (leftHead == null) {
            return rightHead;
        }
        // Link two lists
        leftTraversalNode.next = rightHead;
        return leftHead;
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{3, 5, 8, 5, 10, 2, 1};
        Node head = null;
        for (int node : nodes) {
            head = addNodeToLast(node, head);
        }
        int x = 5;
        print(partition(head, x));

        nodes = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        head = null;
        for (int node : nodes) {
            head = addNodeToLast(node, head);
        }
        x = 4;
        print(partition(head, x));

        nodes = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        head = null;
        for (int node : nodes) {
            head = addNodeToLast(node, head);
        }
        x = 8;
        print(partition(head, x));
    }
}
