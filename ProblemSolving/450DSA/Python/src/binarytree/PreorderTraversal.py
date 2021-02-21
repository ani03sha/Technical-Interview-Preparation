"""
@author Anirudh Sharma

Given a binary tree, write an iterative and recursive solution to traverse the tree using preorder traversal.
"""


def preorderTraversalRecursively(root):
    # Base case
    if root is None:
        return
    print(root.data, end=" ")
    preorderTraversalRecursively(root.left)
    preorderTraversalRecursively(root.right)


def preorderTraversalIteratively(root):
    if root is None:
        return None
    # Stack to store the nodes of the tree
    nodes = []
    # Add root node to the stack
    nodes.append(root)
    # Loop until stack is empty
    while nodes:
        # Get current node
        current = nodes.pop()
        print(current.data, end=" ")
        # Push right child if not null
        if current.right:
            nodes.append(current.right)
        # Push left child if not null
        if current.left:
            nodes.append(current.left)


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


if __name__ == "__main__":
    root = Node(1)
    root.left = Node(3)
    root.right = Node(2)
    print("Recursive:")
    preorderTraversalRecursively(root)
    print("\nIterative:")
    preorderTraversalIteratively(root)
    print("\n")

    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(60)
    print("Recursive:")
    preorderTraversalRecursively(root)
    print("\nIterative:")
    preorderTraversalIteratively(root)
    print("\n")

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    print("Recursive:")
    preorderTraversalRecursively(root)
    print("\nIterative:")
    preorderTraversalIteratively(root)
    print("\n")
