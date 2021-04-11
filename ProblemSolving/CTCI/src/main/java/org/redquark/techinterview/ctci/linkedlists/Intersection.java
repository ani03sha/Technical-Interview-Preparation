package org.redquark.techinterview.ctci.linkedlists;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
 * <p>
 * Note that the intersection is defined based on reference, not value. That is, if the kth node of the
 * first linked list is the exact same node (by reference) as the jth node of the second linked list,
 * then they are intersecting.
 */
public class Intersection {

    private static Node findIntersectingNode(Node head1, Node head2) {
        // Length of lists
        int firstListLength = 0;
        int secondListLength = 0;
        // Reference to both heads
        Node firstListTraversal = head1;
        Node secondListTraversal = head2;
        // Loop over both lists
        while (firstListTraversal != null) {
            firstListLength++;
            firstListTraversal = firstListTraversal.next;
        }
        while (secondListTraversal != null) {
            secondListLength++;
            secondListTraversal = secondListTraversal.next;
        }
        // Difference between the lengths
        int difference = Math.abs(firstListLength - secondListLength);
        // Reset both pointers
        firstListTraversal = head1;
        secondListTraversal = head2;
        // Loop 'difference' number of nodes in the
        // bigger list
        if (firstListLength > secondListLength) {
            for (int i = 0; i < difference; i++) {
                firstListTraversal = firstListTraversal.next;
            }
        } else {
            for (int i = 0; i < difference; i++) {
                secondListTraversal = secondListTraversal.next;
            }
        }
        // Loop until both the nodes are same
        while (firstListTraversal != secondListTraversal) {
            firstListTraversal = firstListTraversal.next;
            secondListTraversal = secondListTraversal.next;
        }
        return firstListTraversal;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        Node head2 = new Node(6);
        head2.next = new Node(5);
        head2.next.next = new Node(4);
        head2.next.next.next = head1.next.next;
        head2.next.next.next.next = new Node(2);
        head2.next.next.next.next.next = new Node(1);

        System.out.println(findIntersectingNode(head1, head2).data);
    }
}
