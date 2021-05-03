package org.redquark.techinterview.mustdolc75;

import org.redquark.techinterview.mustdolc75.utils.LinkedList;

import static org.redquark.techinterview.mustdolc75.utils.LinkedList.ListNode;

/**
 * @author Anirudh Sharma
 * <p>
 * LeetCode #21 - https://leetcode.com/problems/merge-two-sorted-lists/ (EASY)
 * <p>
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Special cases
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // Head of the new list
        ListNode head = null;
        // Reference of the head node
        ListNode temp = null;
        // Loop until lists are empty
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = temp = new ListNode(l1.val);
                } else {
                    temp.next = new ListNode(l1.val);
                    temp = temp.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = temp = new ListNode(l2.val);
                } else {
                    temp.next = new ListNode(l2.val);
                    temp = temp.next;
                }
                l2 = l2.next;
            }
        }
        // For remaining nodes in the l1
        while (l1 != null) {
            temp.next = new ListNode(l1.val);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            temp.next = new ListNode(l2.val);
            temp = temp.next;
            l2 = l2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 4};
        int[] l2 = new int[]{1, 3, 4};
        LinkedList list1 = new LinkedList();
        for (int element : l1) {
            list1.insert(element);
        }
        LinkedList list2 = new LinkedList();
        for (int element : l2) {
            list2.insert(element);
        }
        LinkedList mergedList = new LinkedList();
        mergedList.head = mergeTwoLists(list1.head, list2.head);
        mergedList.print(mergedList.head);
    }
}
