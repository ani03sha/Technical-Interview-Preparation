"""
@author Anirudh Sharma

Given a binary tree of size N, find its reverse level order traversal i.e.,
the traversal must begin from the last level.

Constraints:
1 ≤ N ≤ 10^4
"""


def reverseLevelOrderTraversal(root):
    # List to store the result
    result = []
    # Special case
    if root is None:
        return result
    # Queue to store nodes of the tree
    nodes = []
    # Stack to store the nodes for reverse level order traversal
    reverseLOT = []
    # Add root node to the queue
    nodes.append(root)
    # Loop until the queue is empty
    while nodes:
        # Get the current node
        current = nodes.pop(0)
        # Add this node to the stack
        reverseLOT.insert(0, current)
        # Check if the right child exists
        if current.right:
            nodes.append(current.right)
        # Check if the left child exists
        if current.left:
            nodes.append(current.left)
    # Pop all the nodes from the stack and
    # add them to the result
    while reverseLOT:
        result.append(reverseLOT.pop(0).data)
    return result


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


if __name__ == "__main__":
    root = Node(1)
    root.left = Node(3)
    root.right = Node(2)
    print(reverseLevelOrderTraversal(root))

    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(60)
    print(reverseLevelOrderTraversal(root))
