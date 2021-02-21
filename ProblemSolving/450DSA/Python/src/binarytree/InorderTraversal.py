"""
@author Anirudh Sharma

Given a binary tree, write an iterative and recursive solution to traverse the tree using inorder traversal.
"""


def inorderTraversalRecursively(root):
    # Base case
    if root is None:
        return
    inorderTraversalRecursively(root.left)
    print(root.data, end=" ")
    inorderTraversalRecursively(root.right)


def inorderTraversalIteratively(root):
    # Stack to store the nodes of the tree
    nodes = []
    # Reference of root is stored in the temp node
    temp = root
    # Loop until stack is empty or temp node is null
    while nodes or temp is not None:
        # If the temp node is not None
        if temp is not None:
            nodes.append(temp)
            temp = temp.left
        else:
            temp = nodes.pop()
            print(temp.data, end=" ")
            temp = temp.right


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
    inorderTraversalRecursively(root)
    print("\nIterative:")
    inorderTraversalIteratively(root)
    print("\n")

    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(60)
    print("Recursive:")
    inorderTraversalRecursively(root)
    print("\nIterative:")
    inorderTraversalIteratively(root)
    print("\n")

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    print("Recursive:")
    inorderTraversalRecursively(root)
    print("\nIterative:")
    inorderTraversalIteratively(root)
    print("\n")
