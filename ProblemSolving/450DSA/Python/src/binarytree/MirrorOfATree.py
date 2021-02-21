"""
@author Anirudh Sharma

Given a Binary Tree, find diameter of it.
The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree.

Constraints:
1 <= Number of nodes <= 10000
1 <= Data of a node <= 1000
"""


def mirror(root):
    # Special case
    if root is None:
        return root
    # Get left and right children of the node
    left = mirror(root.left)
    right = mirror(root.right)
    # Swap the nodes
    root.right = left
    root.left = right
    return root


def inorderTraversal(node):
    if node is None:
        return node
    inorderTraversal(node.left)
    print(node.data, end=" ")
    inorderTraversal(node.right)


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


if __name__ == "__main__":
    root = Node(1)
    root.left = Node(3)
    root.right = Node(2)
    inorderTraversal(mirror(root))
    print("\n")

    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(60)
    inorderTraversal(mirror(root))
    print("\n")

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    inorderTraversal(mirror(root))
    print("\n")
