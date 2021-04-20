import sys

"""
@author Anirudh Sharma

Given a sequence of matrices, find the most efficient way to multiply these matrices together.
The problem is not actually to perform the multiplications, but merely to decide in which order
to perform the multiplications.
"""


def chainMultiplicationHelper(orders, i, j, lookup):
    # Base case
    if i == j:
        return 0
    # Check the cache
    if lookup[i][j] != -1:
        return lookup[i][j]
    # Minimum number of operations
    minimumOperations = sys.maxsize
    # Place parentheses at different positions between
    # first and last matrices and recursively calculate
    # the count of operations
    for k in range(i, j):
        count = chainMultiplicationHelper(orders, i, k, lookup) + chainMultiplicationHelper(
            orders, k + 1, j, lookup) + orders[i - 1] * orders[k] * orders[j]
        minimumOperations = min(minimumOperations, count)
    lookup[i][j] = minimumOperations
    return lookup[i][j]


def chainMultiplication(orders):
    # Lookup table
    lookup = [[-1 for y in range(len(orders))] for x in range(len(orders))]
    return chainMultiplicationHelper(orders, 1, len(orders) - 1, lookup)


if __name__ == "__main__":
    orders = [1, 2, 3, 4, 3]
    print(chainMultiplication(orders))

    orders = [10, 30, 5, 60]
    print(chainMultiplication(orders))
