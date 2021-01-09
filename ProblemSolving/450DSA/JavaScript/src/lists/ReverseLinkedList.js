/**
 * @author Anirudh Sharma
 * 
 * Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function)
 * in the linked list.
 */
const reverse = (head) => {
    // Reference of the previous node
    let previous = null;
    // Reference of the current node
    let current = head;
    // Reference of the next node
    let next;
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
};

function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}

function printList(node) {
    let list = [];
    while (node != null) {
        list.push(node.val);
        node = node.next
    }
    console.log(list.join(" "));
}


let headNode = new ListNode(1);
headNode.next = new ListNode(2);
headNode.next.next = new ListNode(3);
headNode.next.next.next = new ListNode(4);
headNode.next.next.next.next = new ListNode(5);
printList(reverse(headNode));

printList(reverse(null));

headNode = new ListNode(1);
printList(reverse(headNode));