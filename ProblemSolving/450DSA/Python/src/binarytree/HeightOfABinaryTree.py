"""
@author Anirudh Sharma

Given a binary tree, find its height.

Constraints:
1 <= Number of nodes <= 10^5
1 <= Data of a node <= 10^5
"""


def getHeight(root):
    # Special case
    if root is None:
        return 0
    # Get the height of the left subtree
    leftHeight = getHeight(root.left)
    # Get the height of the right subtree
    rightHeight = getHeight(root.right)
    # Return the max of left subtree height
    # and right subtree height plus 1 for root
    return 1 + max(leftHeight, rightHeight)



class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


if __name__ == "__main__":
    root = Node(1)
    root.left = Node(3)
    root.right = Node(2)
    print(getHeight(root))

    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(60)
    print(getHeight(root))
