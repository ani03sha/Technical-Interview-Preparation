package org.redquark.techinterview.ctci.linkedlists;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * <p>
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 */
public class LoopDetection {

    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Slow and fast pointers
        Node slow = head;
        Node fast = head;
        // Loop until slow is same as fast
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // If there is no loop, return null
        if (slow != fast) {
            return null;
        }
        // Reset fast to head and compare each node
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = head.next;
        System.out.println(getLoopNode(head).data);

        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = head.next.next;
        System.out.println(getLoopNode(head).data);
    }
}
