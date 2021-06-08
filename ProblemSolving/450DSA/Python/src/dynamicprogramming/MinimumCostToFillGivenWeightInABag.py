import sys

"""
@author Anirudh Sharma

Given an array cost[] of positive integers of size N and an integer W, cost[i] represents
the cost of ‘i’ kg packet of oranges, the task is to find the minimum cost to buy W kgs of oranges.

If it is not possible to buy exactly W kg oranges then the output will be -1

Note:
1. cost[i] = -1 means that ‘i’ kg packet of orange is unavailable
2. It may be assumed that there is infinite supply of all available packet types.
"""


def minimumCost(cost, W):
    # Special case
    if cost is None or len(cost) == 0:
        return -1
    # Length of the cost array
    N = len(cost)
    # Lookup table to store minimum cost
    lookup = [sys.maxsize] * (W + 1)
    # Base initialization
    lookup[0] = 0
    # Populate the table
    for i in range(1, W + 1):
        for j in range(i):
            if j < N and cost[j] != -1:
                difference = lookup[i - j - 1]
                if difference != sys.maxsize:
                    lookup[i] = min(lookup[i], difference + cost[j])
    return -1 if lookup[W] == sys.maxsize else lookup[W]


if __name__ == "__main__":
    cost = [20, 10, 4, 50, 100]
    W = 5
    print(minimumCost(cost, W))

    cost = [-1, -1, 4, 3, -1]
    W = 5
    print(minimumCost(cost, W))
