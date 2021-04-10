package org.redquark.techinterview.ctci.linkedlists;

import static org.redquark.techinterview.ctci.linkedlists.Node.addNodeToLast;
import static org.redquark.techinterview.ctci.linkedlists.Node.print;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
 * not necessarily the exact middle) of a singly linked list, given only access to the head node.
 */
public class DeleteMiddleNode {

    private static Node deleteMiddleNode(Node head) {
        // Special cases
        if (head == null || head.next == null) {
            return null;
        }
        // Slow and fast pointers
        Node slow = head;
        Node fast = head;
        // Node previous to the slow pointer
        Node previous = null;
        // Loop until fast reaches the end
        while (fast.next != null && fast.next.next != null) {
            previous = slow;
            // Move slow one step forward
            slow = slow.next;
            // Move fast two steps forward
            fast = fast.next.next;
        }
        if (previous != null) {
            previous.next = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        for (int i = 1; i <= 6; i++) {
            head = addNodeToLast(i, head);
        }
        print(deleteMiddleNode(head));
    }
}
