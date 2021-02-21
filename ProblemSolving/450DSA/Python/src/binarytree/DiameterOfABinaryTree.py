"""
@author Anirudh Sharma

Given a Binary Tree, find diameter of it.
The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree.

Constraints:
1 <= Number of nodes <= 10000
1 <= Data of a node <= 1000
"""


def height(root):
    # Special case
    if root is None:
        return 0
    # Get the height of the left subtree
    leftHeight = height(root.left)
    # Get the height of the right subtree
    rightHeight = height(root.right)
    # Return the max of left subtree height
    # and right subtree height plus 1 for root
    return 1 + max(leftHeight, rightHeight)


def diameter(root):
    # Base case
    if root is None:
        return 0
    # Heights of left and right subtrees
    leftHeight = height(root.left)
    rightHeight = height(root.right)
    # Diameters of left and right subtrees
    leftDiameter = diameter(root.left)
    rightDiameter = diameter(root.right)

    return max(leftDiameter, rightDiameter, leftHeight + rightHeight + 1)


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


if __name__ == "__main__":
    root = Node(1)
    root.left = Node(3)
    root.right = Node(2)
    print(diameter(root))

    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(60)
    print(diameter(root))

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    print(diameter(root))


