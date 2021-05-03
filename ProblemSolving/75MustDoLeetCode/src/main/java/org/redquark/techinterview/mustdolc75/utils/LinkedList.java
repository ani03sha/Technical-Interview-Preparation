package org.redquark.techinterview.mustdolc75.utils;

public class LinkedList {

    public ListNode head;

    public void insert(int element) {
        // Create a new node with the given data
        ListNode node = new ListNode(element);
        // If the head is null
        if (head == null) {
            head = node;
            return;
        }
        // Reference of the head node
        ListNode temp = head;
        // Loop until the end of the list
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void print(ListNode head) {
        StringBuilder sb = new StringBuilder("[ ");
        // Reference of the head
        ListNode temp = head;
        if (temp == null) {
            System.out.println("[]");
            return;
        }
        // Loop until the second last node
        while (temp.next != null) {
            sb.append(temp.val).append(", ");
            temp = temp.next;
        }
        sb.append(temp.val).append(" ]");
        System.out.println(sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        // Reference of the head
        ListNode temp = head;
        // Loop until the second last node
        while (temp.next != null) {
            sb.append(temp.val).append(", ");
            temp = temp.next;
        }
        sb.append(temp.val).append(" ]");
        return sb.toString();
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
