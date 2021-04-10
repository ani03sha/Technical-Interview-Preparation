package org.redquark.techinterview.ctci.linkedlists;

import java.util.HashSet;
import java.util.Set;

import static org.redquark.techinterview.ctci.linkedlists.Node.addNodeToLast;
import static org.redquark.techinterview.ctci.linkedlists.Node.print;

/**
 * @author Anirudh Sharma
 * <p>
 * Write code to remove duplicates from an unsorted linked list.
 * <p>
 * FOLLOW UP:
 * How would you solve this problem if temporary buffer is not allowed?
 */
public class RemoveDuplicates {

    private static Node remove(Node head) {
        // Special case
        if (head == null) {
            return null;
        }
        // Set to store the nodes to check for duplicates
        Set<Integer> duplicates = new HashSet<>();
        // Previous node to the current node
        Node previous = null;
        // Current node
        Node current = head;
        // Loop until current node is not null
        while (current != null) {
            // Check if the node is already in the set
            if (duplicates.contains(current.data)) {
                // Skip the current node
                previous.next = current.next;
            }
            // If the node is for the first time
            else {
                // Add it to the set
                duplicates.add(current.data);
                // Make current node as the previous node
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        for (int i = 1; i <= 5; i++) {
            head = addNodeToLast(i, head);
        }
        print(remove(head));

        head = null;
        for (int i = 1; i <= 10; i += 2) {
            head = addNodeToLast(i, head);
            head = addNodeToLast(i, head);
        }
        print(remove(head));

        int[] nodes = {5, 3, 4, 2, 5, 4, 1, 3};
        head = null;
        for (int node : nodes) {
            head = addNodeToLast(node, head);
        }
        print(remove(head));

        print(remove(null));
    }
}
