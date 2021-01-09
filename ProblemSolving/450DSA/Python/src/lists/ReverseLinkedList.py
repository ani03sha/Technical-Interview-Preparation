"""
@author Anirudh Sharma

Given pointer to the head node of a linked list, the task is to reverse the linked list.
We need to reverse the list by changing the links between nodes.
"""


class ListNode:
    def __init__(self, val=0, nextNode=None):
        self.val = val
        self.next = nextNode


def reverse(headNode):
    # Reference of the previous node
    previousNode = None
    # Reference of the current node
    currentNode = headNode
    # Reference of the next node
    nextNode = None
    # Loop through the nodes of the list
    while currentNode is not None:
        # Get the next node
        nextNode = currentNode.next
        # Next of the current node should point to previous node
        currentNode.next = previousNode
        # Make current node as the previous node for the next iteration
        previousNode = currentNode
        # Move the node ahead
        currentNode = nextNode
    currentNode = previousNode
    return currentNode


def printList(headNode):
    temp = headNode
    while temp is not None:
        print(temp.val, end=" ")
        temp = temp.next
    print()


if __name__ == "__main__":
    headNode = ListNode(1)
    headNode.next = ListNode(2)
    headNode.next.next = ListNode(3)
    headNode.next.next.next = ListNode(4)
    headNode.next.next.next.next = ListNode(5)
    printList(reverse(headNode))

    printList(reverse(None))

    headNode = ListNode(1)
    printList(reverse(headNode))
