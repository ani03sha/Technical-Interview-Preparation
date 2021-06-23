"""
@author Anirudh Sharma

A Derangement is a permutation of n elements, such that no element appears in its original position.
For example, a derangement of {0, 1, 2, 3} is {2, 3, 1, 0}.

Given a number n, find the total number of Derangements of a set of n elements.
"""


def count(n):
    # Lookup table to store derangements for
    # a particular value of n
    lookup = [0] * (n + 1)
    # Base initialization
    lookup[1] = 0
    lookup[2] = 1
    # Populate for remaining places
    for i in range(3, n + 1):
        lookup[i] = (i - 1) * (lookup[i - 1] + lookup[i - 2])
    return lookup[n]


if __name__ == "__main__":
    print(count(3))
    print(count(4))
