import sys

"""
@author Anirudh Sharma

You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

Constraints:

n == pairs.length
1 <= n <= 1000
-1000 <= lefti < righti < 1000
"""


def findLongestChain(pairs):
    # Special case
    if pairs is None or len(pairs) == 0:
        return 0
    # Sort the array by first element
    pairs = sorted(pairs, key=lambda a: a[0])
    # Length of the array
    n = len(pairs)
    # Lookup table to store the maximum chain length
    # until that index
    # Since every pair is a valid chain pair of length 1
    lookup = [1] * n
    # Populate the table
    for i in range(1, n):
        for j in range(i):
            # Compare the two pairs' first and second values
            if pairs[i][0] > pairs[j][1]:
                lookup[i] = max(lookup[i], lookup[j] + 1)
    # Find the maximum value stored in the lookup table
    maxLength = -sys.maxsize
    for l in lookup:
        maxLength = max(l, maxLength)
    return maxLength


if __name__ == "__main__":
    pairs = [[1, 2], [2, 3], [3, 4]]
    print(findLongestChain(pairs))

    pairs = [[1, 2], [7, 8], [4, 5]]
    print(findLongestChain(pairs))
