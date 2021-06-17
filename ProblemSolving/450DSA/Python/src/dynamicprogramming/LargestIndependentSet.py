"""
@author Anirudh Sharma

Given a Binary Tree, find size of the Largest Independent Set(LIS) in it.

A subset of all tree nodes is an independent set if there is no edge between any
two nodes of the subset.
"""


def largestIndependentSet(root):
    # Special cases
    if root is None:
        return 0
    if root.lis != 0:
        return root.lis
    if root.left is None and root.right is None:
        root.lis = 1
        return root.lis
    # LIS if we exclude current node
    exclude = largestIndependentSet(
        root.left) + largestIndependentSet(root.right)
    # LIS if we include current node
    include = 1
    if root.left is not None:
        include += largestIndependentSet(root.left.left) + \
            largestIndependentSet(root.left.right)
    if root.right is not None:
        include += largestIndependentSet(root.right.left) + \
            largestIndependentSet(root.right.right)
    return max(include, exclude)


class TreeNode:
    def __init__(self, data):
        self.data = data
        self.lis = 0
        self.left = None
        self.right = None


if __name__ == "__main__":
    root = TreeNode(20)
    root.left = TreeNode(8)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(12)
    root.left.right.left = TreeNode(10)
    root.left.right.right = TreeNode(14)
    root.right = TreeNode(22)
    root.right.right = TreeNode(25)
    print(largestIndependentSet(root))
