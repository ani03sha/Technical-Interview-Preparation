package org.redquark.techinterview.mustdolc75;

import org.redquark.techinterview.mustdolc75.utils.LinkedList;

import static org.redquark.techinterview.mustdolc75.utils.LinkedList.ListNode;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        // Special case
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeLists(ListNode[] lists, int start, int end) {
        // Base case
        if (start == end) {
            return lists[start];
        }
        // Find the middle index
        int middle = start + (end - start) / 2;
        // Get the left half
        ListNode left = mergeLists(lists, start, middle);
        // Get the right half
        ListNode right = mergeLists(lists, middle + 1, end);
        // Merge left and right halves
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        // Create a dummy node
        ListNode head = new ListNode(-1);
        // Reference of the head
        LinkedList.ListNode temp = head;
        // Loop until we have elements in both the lists
        while (left != null && right != null) {
            // Choose the value which is smaller of the
            // two lists to insert
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        // Process for remaining nodes
        while (left != null) {
            temp.next = left;
            temp = temp.next;
            left = left.next;
        }
        while (right != null) {
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5};
        int[] b = {1, 3, 4};
        int[] c = {2, 6};
        LinkedList list1 = new LinkedList();
        for (int element : a) {
            list1.insert(element);
        }
        LinkedList list2 = new LinkedList();
        for (int element : b) {
            list2.insert(element);
        }
        LinkedList list3 = new LinkedList();
        for (int element : c) {
            list3.insert(element);
        }
        LinkedList mergedList = new LinkedList();
        mergedList.print(mergeKLists(new ListNode[]{list1.head, list2.head, list3.head}));
    }
}
