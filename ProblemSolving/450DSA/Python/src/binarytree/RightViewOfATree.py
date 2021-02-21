"""
@author Anirudh Sharma

Given a Binary Tree, print right view of it.
Left view of a Binary Tree is set of nodes visible when tree is visited from right side.
"""


def rightView(root):
    # list to store the result
    result = []
    # Special case
    if root is None:
        return result
    # Queue to store the nodes of the tree
    nodes = []
    # Add the root node in the queue
    nodes.append(root)
    # Loop until the queue is empty
    while nodes:
        # Get the size of the queue
        size = len(nodes)
        # Loop until the size
        for i in range(size):
            # Get the current node
            current = nodes.pop(0)
            # If it is the first node at the current level,
            # add it to the result
            if i == size - 1:
                result.append(current.data)
            # Move to left child if exists
            if current.left:
                nodes.append(current.left)
            # Move to right child if exists
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
    print(rightView(root))

    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(60)
    print(rightView(root))

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    print(rightView(root))
