package org.redquark.techinterview.dsa.lists;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function)
 * in the linked list.
 */
public class ReverseALinkedListInGroupOfK {

    private static Node reverseInGroupOfK(Node head, int k) {
        // Base condition
        if (head == null || k == 1) {
            return head;
        }
        // Dummy node
        Node dummy = new Node(-1);
        // Link dummy node to the head
        dummy.next = head;
        // Make dummy as the previous node
        Node previous = dummy;
        // Reference of the current node
        Node current = head;
        // Variable to store the number of nodes traversed
        int count = 0;
        // Loop through the list
        while (current != null) {
            count++;
            // Check if the count is divisible by k.
            // If it is then we need to reverse the sublist
            // between previous and current.next
            if (count % k == 0) {
                previous = reverse(previous, current.next);
                // Update the current node
                current = previous.next;
            }
            // If the count is not divisible by k then move
            // the pointer ahead
            else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    private static Node reverse(Node start, Node end) {
        // Previous node of the current node
        Node previous = start.next;
        // Current node
        Node current = previous.next;
        // Next node of the current node
        Node next;
        // Loop for the whole interval
        while (current != end) {
            // Next node of the current node
            next = current.next;
            // Next of current will point to the previous
            current.next = start.next;
            // Current node will become the previous node
            start.next = current;
            // Move pointer ahead
            current = next;
        }
        previous.next = end;
        // Return head node of the reversed linked list
        return previous;
    }

    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        printList(reverseInGroupOfK(head, 2));

        printList(reverseInGroupOfK(null, 2));

        head = new Node(1);
        printList(reverseInGroupOfK(head, 3));
    }

    static class Node {
        final int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
