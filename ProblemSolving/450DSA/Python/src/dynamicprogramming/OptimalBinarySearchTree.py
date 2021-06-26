import sys

"""
@author Anirudh Sharma

Given a sorted array key [0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts,
where freq[i] is the number of searches for keys[i].

Construct a binary search tree of all keys such that the total cost of all the searches is as small
as possible.

The cost of a BST node is the level of that node multiplied by its frequency. The level of the root is 1.
"""


def getSum(frequencies, i, j):
    s = 0
    for k in range(i, j + 1):
        if k >= len(frequencies):
            continue
        s += frequencies[k]
    return s


def optimalCost(keys, frequencies):
    # Base case
    if keys is None or len(keys) == 0:
        return 0
    # Total number of keys/nodes in BST
    n = len(keys)
    # Lookup table to store optimal costs
    lookup = [[0 for y in range(n + 1)] for x in range(n + 1)]
    # For single keys
    for i in range(n):
        lookup[i][i] = keys[i]
    # Populate the table
    for level in range(1, n + 1):
        for i in range(n - level + 2):
            j = level + i - 1
            lookup[i][j] = sys.maxsize
            for k in range(i, j + 1):
                x = getSum(frequencies, i, j) + \
                    (lookup[i][k - 1] if k > i else 0) + \
                    (lookup[k + 1][j] if k < j else 0)
                if x < lookup[i][j]:
                    lookup[i][j] = x
    return lookup[0][n - 1]


if __name__ == "__main__":
    keys = [10, 12, 20]
    frequencies = [34, 8, 50]
    print(optimalCost(keys, frequencies))
