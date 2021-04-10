package org.redquark.techinterview.ctci.linkedlists;

public class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    static Node addNodeToLast(int data, Node head) {
        // Create a new node with the given data
        Node end = new Node(data);
        if (head == null) {
            return end;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = end;
        return head;
    }

    static void print(Node head) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp.next != null) {
            sb.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        sb.append(temp.data);
        System.out.println(sb);
    }
}
