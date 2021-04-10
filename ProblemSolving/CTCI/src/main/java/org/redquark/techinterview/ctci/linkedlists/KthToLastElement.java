package org.redquark.techinterview.ctci.linkedlists;

import static org.redquark.techinterview.ctci.linkedlists.Node.addNodeToLast;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
public class KthToLastElement {

    private static Node findKthToLast(Node head, int k) {
        // Special case
        if (head == null) {
            return null;
        }
        // Slow and fast pointers
        Node slow = head;
        Node fast = head;
        // Move fast pointer to the kth node from the beginning
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        // Now move both pointers one step at a time
        // until the fast pointer reaches to the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = null;
        for (int i = 1; i <= 10; i++) {
            head = addNodeToLast(i, head);
        }
        int k = 4;
        System.out.println(findKthToLast(head, k).data);

        head = null;
        int[] nodes = {35, 15, 4, 20};
        for (int node : nodes) {
            head = addNodeToLast(node, head);
        }
        k = 4;
        System.out.println(findKthToLast(head, k).data);
    }
}
