from sortedcontainers import SortedDict
"""
@author Anirudh Sharma

Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

Constraints:
1 <= Number of nodes <= 10^5
1 <= Data of a node <= 10^5
"""


def bottomView(root):
    # List to store the result
    result = []
    # Special case
    if root is None:
        return result
    # Horizontal distance for a node. 
    # It will be zero for the root node.
    horizontalDistance = 0
    # TreeMap to store node's data, height and
    # horizontal distance
    treeMap = SortedDict()
    # Queue to store the nodes in level order traversal
    nodes = []
    # Initialize the values
    root.horizontalDistance = horizontalDistance
    nodes.append(root)
    # Loop until the queue is empty
    while nodes:
        # Get the current node from the head
        current = nodes.pop(0)
        # Get the current horizontal distance
        horizontalDistance = current.horizontalDistance
        # Put the dequeued tree node to TreeMap having key
        # as horizontal distance. Every time we find a node
        # having same horizontal distance we need to replace
        # the data in the map.
        treeMap[horizontalDistance] = current.data
        # Check for the left and right children
        if current.left:
            current.left.horizontalDistance = horizontalDistance - 1
            nodes.append(current.left)
        if current.right:
            current.right.horizontalDistance = horizontalDistance + 1
            nodes.append(current.right)
    # Populate the result list
    for value in treeMap.values():
        result.append(value)
    return result


class Node:
    def __init__(self, data):
        self.data = data
        self.horizontalDistance = 0
        self.left = None
        self.right = None


if __name__ == "__main__":
    root = Node(20)
    root.left = Node(8)
    root.right = Node(22)
    root.left.left = Node(5)
    root.left.right = Node(3)
    root.right.left = Node(4)
    root.right.right = Node(25)
    root.left.right.left = Node(10)
    root.left.right.right = Node(14)
    print(bottomView(root))