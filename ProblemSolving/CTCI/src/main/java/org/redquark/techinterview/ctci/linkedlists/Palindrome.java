package org.redquark.techinterview.ctci.linkedlists;

import static org.redquark.techinterview.ctci.linkedlists.Node.addNodeToLast;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement a function to check if a linked list is a palindrome.
 */
public class Palindrome {

    private static boolean isPalindrome(Node head) {
        // Special case
        if (head == null) {
            return true;
        }
        // Slow and fast pointers
        Node slow = head;
        Node fast = head;
        // Loop until fast pointer reaches to the end
        // of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // At this point slow is pointing to middle
        // of the linked list, so we reverse the right
        // half of the list
        Node right = reverse(slow);
        // Left half of the list
        Node left = head;
        // Now compare left and right halves
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private static Node reverse(Node node) {
        // Previous to current node
        Node previous = null;
        // current node
        Node current = node;
        // Next to the current node
        Node next;
        // Loop until we reach the end
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{1, 4, 6, 4, 1};
        Node head = null;
        for (int node : nodes) {
            head = addNodeToLast(node, head);
        }
        System.out.println(isPalindrome(head));

        nodes = new int[]{5, 4, 4, 5};
        head = null;
        for (int node : nodes) {
            head = addNodeToLast(node, head);
        }
        System.out.println(isPalindrome(head));

        nodes = new int[]{1, 6, 5, 4, 3, 5, 6, 1};
        head = null;
        for (int node : nodes) {
            head = addNodeToLast(node, head);
        }
        System.out.println(isPalindrome(head));

        nodes = new int[]{7, 8, 4, 4, 8, 7, 5};
        head = null;
        for (int node : nodes) {
            head = addNodeToLast(node, head);
        }
        System.out.println(isPalindrome(head));
    }
}
