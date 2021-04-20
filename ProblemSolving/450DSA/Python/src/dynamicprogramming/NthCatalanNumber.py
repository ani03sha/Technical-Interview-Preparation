"""
@author Anirudh Sharma
Find n-th catalan number
"""


def findCatalanHelper(n, lookup):
    # Base case
    if n <= 1:
        return 1
    # Check if the value is cached in the lookup table
    if lookup[n] != -1:
        return lookup[n]
    # Variable to store result
    result = 0
    for i in range(n):
        result += findCatalanHelper(i, lookup) * \
            findCatalanHelper(n - i - 1, lookup)
    # Cache value
    lookup[n] = result
    return lookup[n]


def findCatalan(n):
    # Lookup table
    lookup = [-1] * (n + 1)
    return findCatalanHelper(n, lookup)


if __name__ == "__main__":
    print(findCatalan(8))
    print(findCatalan(14))
    print(findCatalan(21))
