"""
@author Anirudh Sharma

Given a binary tree, find its level order traversal.
Level order traversal of a tree is breadth-first traversal for the tree.

Constraints:
1 <= Number of nodes<= 10^4
1 <= Data of a node <= 10^4
"""


def levelOrderTraversal(root):
    # Special case
    if root is None:
        return None
    # List to store the result
    result = []
    # Queue to store nodes of the tree
    nodes = []
    # Add root node to the queue
    nodes.append(root)
    # Loop until the queue is empty
    while nodes:
        # Get the current node
        current = nodes.pop(0)
        # Add this node to the result
        result.append(current.data)
        # Check if the left child exists
        if current.left:
            nodes.append(current.left)
        # Check if the right child exists
        if current.right:
            nodes.append(current.right)
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
    print(levelOrderTraversal(root))

    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(60)
    print(levelOrderTraversal(root))
