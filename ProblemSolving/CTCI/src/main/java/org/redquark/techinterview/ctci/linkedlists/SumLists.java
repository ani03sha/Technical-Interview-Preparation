package org.redquark.techinterview.ctci.linkedlists;

import static org.redquark.techinterview.ctci.linkedlists.Node.addNodeToLast;
import static org.redquark.techinterview.ctci.linkedlists.Node.print;

/**
 * @author Anirudh Sharma
 * <p>
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * <p>
 * The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * <p>
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2) .Thatis,617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 */
public class SumLists {

    private static Node sumBackward(Node head1, Node head2) {
        // Special cases
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        // List to store the sum
        Node sumHead = null;
        Node sumTraversalNode = null;
        // Carry of sum
        int carry = 0;
        // Loop through lists
        while (head1 != null || head2 != null) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            // Create a new node with the data
            Node sumNode = new Node(sum % 10);
            carry = sum / 10;
            if (sumHead == null) {
                sumHead = sumTraversalNode = sumNode;
            } else {
                sumTraversalNode.next = sumNode;
                sumTraversalNode = sumTraversalNode.next;
            }
        }
        // For remaining nodes
        if (carry > 0) {
            sumTraversalNode.next = new Node(carry);
        }
        return sumHead;
    }

    private static Node sumForward(Node head1, Node head2) {
        // Special cases
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        // Reverse linked lists
        head1 = reverse(head1);
        head2 = reverse(head2);
        return reverse(sumBackward(head1, head2));
    }

    private static Node reverse(Node node) {
        // Previous node
        Node previous = null;
        // Current node
        Node current = node;
        // Next node
        Node next;
        // Loop through the list
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{7, 1, 6};
        Node head1 = null;
        for (int node : nodes) {
            head1 = addNodeToLast(node, head1);
        }
        nodes = new int[]{5, 9, 2};
        Node head2 = null;
        for (int node : nodes) {
            head2 = addNodeToLast(node, head2);
        }
        print(sumBackward(head1, head2));

        nodes = new int[]{4, 9, 5};
        head1 = null;
        for (int node : nodes) {
            head1 = addNodeToLast(node, head1);
        }
        nodes = new int[]{5, 1, 8};
        head2 = null;
        for (int node : nodes) {
            head2 = addNodeToLast(node, head2);
        }
        print(sumBackward(head1, head2));

        nodes = new int[]{6, 1, 7};
        head1 = null;
        for (int node : nodes) {
            head1 = addNodeToLast(node, head1);
        }
        nodes = new int[]{2, 9, 5};
        head2 = null;
        for (int node : nodes) {
            head2 = addNodeToLast(node, head2);
        }
        print(sumForward(head1, head2));

        nodes = new int[]{5, 9, 4};
        head1 = null;
        for (int node : nodes) {
            head1 = addNodeToLast(node, head1);
        }
        nodes = new int[]{8, 1, 5};
        head2 = null;
        for (int node : nodes) {
            head2 = addNodeToLast(node, head2);
        }
        print(sumForward(head1, head2));

        nodes = new int[]{6, 4, 0, 8};
        head1 = null;
        for (int node : nodes) {
            head1 = addNodeToLast(node, head1);
        }
        nodes = new int[]{8, 1, 5};
        head2 = null;
        for (int node : nodes) {
            head2 = addNodeToLast(node, head2);
        }
        print(sumBackward(head1, head2));

        nodes = new int[]{8, 0, 4, 6};
        head1 = null;
        for (int node : nodes) {
            head1 = addNodeToLast(node, head1);
        }
        nodes = new int[]{5, 1, 8};
        head2 = null;
        for (int node : nodes) {
            head2 = addNodeToLast(node, head2);
        }
        print(sumForward(head1, head2));
    }
}
