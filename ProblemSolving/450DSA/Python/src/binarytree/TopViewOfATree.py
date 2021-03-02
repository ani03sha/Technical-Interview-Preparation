from sortedcontainers import SortedDict

"""
@author Anirudh Sharma

Given a pointer to the root of a binary tree, print the top view of the binary tree.

The tree as seen from the top the nodes, is called the top view of the tree.

Constraints:
1 <= N <= 10^5
1 <= Node Data <= 10^5
"""


def topViewHelper(root, verticalDistance, horizontalDistance, treeMap):
    # Base condition
    if root is None:
        return
    # If the node for a horizontal distance is not
    # present in the map, add it.
    if treeMap.get(horizontalDistance) is None:
        treeMap[horizontalDistance] = Pair(root.data, verticalDistance)
    # If the node for a horizontal distance is present,
    # then we will pick up the node that comes first
    else:
        currentPair = treeMap[horizontalDistance]
        if currentPair.height >= verticalDistance:
            treeMap[horizontalDistance] = Pair(root.data, verticalDistance)
    # Recursive calls to left and right subtrees
    topViewHelper(root.left, verticalDistance + 1,
                  horizontalDistance - 1, treeMap)
    topViewHelper(root.right, verticalDistance + 1,
                  horizontalDistance + 1, treeMap)


def topView(root):
    # List to store the result
    result = []
    # TreeMap to store node's data, height and
    # horizontal distance
    treeMap = SortedDict()
    topViewHelper(root, 0, 0, treeMap)
    for value in treeMap.values():
        result.append(value.nodeData)
    return result


class Pair:
    def __init__(self, nodeData, height):
        self.nodeData = nodeData
        self.height = height


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


if __name__ == "__main__":
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.left.left = Node(8)
    root.left.left.right = Node(9)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)
    print(topView(root))

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.right = Node(4)
    root.right.left = Node(5)
    root.right.right = Node(6)
    root.right.left.left = Node(7)
    root.right.left.right = Node(8)
    print(topView(root))
