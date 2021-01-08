package org.redquark.techinterview.dsa.lists;

/**
 * @author Anirudh Sharma
 * <p>
 * Given pointer to the head node of a linked list, the task is to reverse the linked list.
 * We need to reverse the list by changing the links between nodes.
 */
public class ReverseLinkedList {

    private static Node reverse(Node head) {
        // Reference of the previous node
        Node previous = null;
        // Reference of the current node
        Node current = head;
        // Reference of the next node
        Node next;
        // Loop until current is null
        while (current != null) {
            // Get the next node
            next = current.next;
            // Next of the current node should point to previous node
            current.next = previous;
            // Make current node as the previous node for the next iteration
            previous = current;
            // Move the node ahead
            current = next;
        }
        current = previous;
        return current;
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
        printList(reverse(head));

        printList(reverse(null));

        head = new Node(1);
        printList(reverse(head));
    }

    static class Node {
        final int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
