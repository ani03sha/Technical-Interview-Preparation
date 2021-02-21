"""
@author Anirudh Sharma

Given a binary tree, write an iterative and recursive solution to traverse the tree using preorder traversal.
"""


def postorderTraversalRecursively(root):
    # Base case
    if root is None:
        return
    postorderTraversalRecursively(root.left)
    postorderTraversalRecursively(root.right)
    print(root.data, end=" ")


def postorderTraversalIteratively(root):
    if root is None:
        return None
    # Stack to store the nodes of the tree
    nodes = []
    # Add root node to the stack
    nodes.append(root)
    # Stack to store the post order traversal
    postOrder = []
    # Loop until stack is empty
    while nodes:
        # Get current node
        current = nodes.pop()
        postOrder.append(current.data)
        # Push left child if not null
        if current.left:
            nodes.append(current.left)
        # Push right child if not null
        if current.right:
            nodes.append(current.right)
    while postOrder:
        print(postOrder.pop(), end=" ")


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
    postorderTraversalRecursively(root)
    print("\nIterative:")
    postorderTraversalIteratively(root)
    print("\n")

    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(60)
    print("Recursive:")
    postorderTraversalRecursively(root)
    print("\nIterative:")
    postorderTraversalIteratively(root)
    print("\n")

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    print("Recursive:")
    postorderTraversalRecursively(root)
    print("\nIterative:")
    postorderTraversalIteratively(root)
    print("\n")
