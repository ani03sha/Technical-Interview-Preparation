"""
@author Anirudh Sharma

Given a set of N items, each with a weight and a value, and a weight limit W.

Find the maximum value of a collection containing any of the N items any number
of times so that the total weight is less than or equal to W.
"""


def unboundedKnapsack(values, weights, W):
    # Special cases
    if values is None or weights is None or len(values) == 0 or len(weights) == 0:
        return 0
    # Lookup table to store the collection
    lookup = [0] * (W + 1)
    # Populated lookup table
    for i in range(W + 1):
        for j in range(len(values)):
            if weights[j] <= i:
                lookup[i] = max(lookup[i], values[j] + lookup[i - weights[j]])
    return lookup[W]


if __name__ == "__main__":
    values = [1, 1]
    weights = [2, 1]
    W = 3
    print(unboundedKnapsack(values, weights, W))

    values = [1, 4, 5, 7]
    weights = [1, 3, 4, 5]
    W = 8
    print(unboundedKnapsack(values, weights, W))
