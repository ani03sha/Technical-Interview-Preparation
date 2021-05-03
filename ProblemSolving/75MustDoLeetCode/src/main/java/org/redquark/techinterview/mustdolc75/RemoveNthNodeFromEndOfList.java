package org.redquark.techinterview.mustdolc75;

import org.redquark.techinterview.mustdolc75.utils.LinkedList;

import static org.redquark.techinterview.mustdolc75.utils.LinkedList.ListNode;

/**
 * @author Anirudh Sharma
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Special case
        if (head == null) {
            return null;
        }
        // Slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        // Loop until the fast pointer reaches to the node before
        // the node to be deleted
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            // If the n-th node from last is the head of the list
            if (fast == null) {
                return head.next;
            }
        }
        // Now loop until fast pointer reaches to the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // At this point the slow will be pointing to the
        // (n - 1)th node.
        // Mark the next of this node to the next of next node
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] elements = new int[]{1, 2, 3, 4, 5};
        int n = 2;
        for (int element : elements) {
            list.insert(element);
        }
        list.print(removeNthFromEnd(list.head, n));

        list = new LinkedList();
        elements = new int[]{1};
        n = 1;
        for (int element : elements) {
            list.insert(element);
        }
        list.print(removeNthFromEnd(list.head, n));
    }
}
